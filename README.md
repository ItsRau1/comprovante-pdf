# Comprovante PDF

## Modelo de Comprovante

![Comprovante](./doc/comprovante.png)

## Sobre o Projeto

Este projeto é uma API que gera comprovantes de pagamentos para um banco fictício (RDBank), e surgiu da curiosidade de como eram gerados arquivos PDFs dinamicamente utilizando Java. Durante o processo de exploração desta ideia passei por algumas bibliotecas, mas acabei optando pela "ItextPDF", por diversos motivos, mas ressalto a escalabilidade e robustez de sua construção.

## Estrutura do projeto

A arquitetura escolhida para o desenvolvimento foi Arquitetura Limpa combinada com elementos de Domain-driven design.

```
└──src
    ├── main
        ├── java
        │   └── com
        │   │   └── poc
        │   │       └── comprovantepdf
        │   │           ├── ComprovantePDFApplication.java
        │   │           ├── core
        │   │               ├── domains
        │   │               │   ├── dto
        │   │               │   ├── entity
        │   │               │   ├── exception
        │   │               │   └── gateway
        │   │               ├── formatter
        │   │               └── usecase
        │   │           ├── inbound
        │   │               └── controller
        │   │           └── outbound
        │   │               └── itextpdf
        │   │                   ├── dto
        │   │                   ├── factory
        │   │                   ├── gateway
        │   │                   ├── property
        │   │                   └── strategy
        │   │                       ├── impressor
        │   │                           └── impl
        │   │                       └── template
        │   │                           └── impl
        └── resources
        │   ├── application.properties
        │   ├── fonts
        │   ├── images
        │   └── pdf
    └── test
        └── java
            └── com
                └── poc
                    └── comprovantepdf
                        └── inbound
                            └── controller
```

Explorando mais a fundo a estrutura da pasta `itextpdf`, está dividida da seguinte forma:

- `dto` - Estruturas para transferência de dados durante a geração do PDF
- `factory` - Geradores de códigos para evitar duplicação
- `gateway` - Implementação do gateway definido no Core da aplicação
- `property` - Enums que definem propriedades comuns utilizadas durante a geração do PDF
- `strategy` - Onde estão localizados os Impressores e Templates.

## Impressores

As informações em um PDF são aceitas como tabelas, então durante o desenvolvimento dessa POC observei uma forma de padronizar a "impressão" de informações, pode meio de uma Pattern que apelidei de "Impressor". Seu funcionamento é semelhante a uma Strategy, precisando definir uma interface para seus impressores:

```java
public interface ImpressorPDFStrategy {

	void imprimir(Document document, Command data);

}
```

Segue exemplo de uma implementação desta interface:

```java
@Component
@Order(1)
public class HeaderPDF implements ImpressorPDFStrategy {

	@Override
	public void imprimir(Document document, Command command) {
		Table table = new Table(842f); // Largura de uma folha A4 em modo paisagem

		table.addCell(new Cell()
            .setBorder(Border.NO_BORDER)
			.add(command.getHelloWorld())
        );

		document.add(table);
	}

}
```

É de suma importância a definição do Decorator "Order" no inicio do impressor, para preservar a ordem das impressões. Após a definição da interface e implantação da mesma, é necessário criar um Navigation para ser possível a impressão de todas as informações no PDF, como no exemplo abaixo:

```java
@Component
@RequiredArgsConstructor
public class ImpressorPDFNavigation {

	private final List<ImpressorPDFStrategy> impressors;

	public void execute(Document document, GerarComprovanteCommand data) {
		this.impressors.forEach(impressor -> impressor.imprimir(document, data));
	}

}
```

Com o nosso Navigation capturando todas as implementações de nossos impressores e percorrendo todos eles, e imprimindo informações em nosso PDF, agora vem a parte mais simples, utilizar tudo oque construímos:

```java
@Component
@RequiredArgsConstructor
public class ComprovanteGatewayItextPDF implements ComprovanteGateway {

	@Autowired
	ImpressorPDFNavigation impressorPDFNavigation;

	@Override
	public void gerar(GerarComprovanteCommand command) {
		ComprovantePDF comprovantePDF = new ComprovantePDF(command);
		DocumentDTO documentDTO = DocumentFactory.generate(comprovantePDF);
		impressorPDFNavigation.execute(documentDTO.getDocument(), command);
		documentDTO.getDocument().close();
    }

}

```

## Templates

Idealizei este Pattern durante o desenvolvimento desta POC, quando se fez necessário a adição de uma informação em todas as páginas do arquivo PDF, dessa dor surgiu a ideia de um Pattern onde existem Templates de informações que devem ser aplicados em todas as páginas, sua implementação também é muito semelhante a uma Strategy, também sendo dependente de uma interface:

```java
public interface TemplatePDFStrategy {

	void apply(DocumentDTO documentDTO, Command comprovante);

}
```

Segue exemplo de uma implementação desta interface:

```java
@Component
public class IdentificadorPDF implements TemplatePDFStrategy {

	@Override
	public void apply(DocumentDTO documentDTO, Command command) {
		int numberOfPages = documentDTO.getPdfDocument().getNumberOfPages();

		Paragraph identificador = new Paragraph();
		identificador.add(new Text("Identificador: "));
		identificador.add(command.getIdentificador());

		for (int i = 1; i <= numberOfPages; i++) {
			documentDTO.getDocument()
				.showTextAligned(identificador, 421, 24, i, TextAlignment.CENTER, VerticalAlignment.BOTTOM, 0);
		}
	}

}
```

Você pode perceber que diferente das implementações de impressores, as implementações de "Template" não necessitam do Decorator "Order", como são informações impressas em todas as páginas, suas posições são definidas por coordenadas. Em contrapartida, como no Pattern de Impressores também se faz necessário um Navigation:

```java
@Component
@RequiredArgsConstructor
public class TemplatePDFNavigation {

	private final List<TemplatePDFStrategy> templates;

	public void execute(DocumentDTO documentDTO, Command command) {
        templates.forEach(template -> template.apply(documentDTO, command));
	}

}
```
