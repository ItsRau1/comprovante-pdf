# Sobre o Projeto

Este projeto é uma API que gera comprovantes de pagamentos para um banco fictício (RDBank), e surgiu da curiosidade de como eram gerados arquivos PDFs dinamicamente utilizando Java. Durante o processo de exploração desta ideia passei por algumas bibliotecas, mas acabei optando pela "ItextPDF", por diversos motivos, mas ressalto a escalabilidade e robustez de sua construção.

# Linguagem Utilizada

- Java 17

# Estrutura

A arquitetura escolhida para o desenvolvimento foi Arquitetura Limpa combinada com elementos de Domain-driven design.

```
├── pom.xml
└── src
    ├── main
        ├── java
        │   └── com
        │   │   └── poc
        │   │       └── comprovantepdf
        │   │           ├── ComprovantePDFApplication.java
        │   │           ├── core
        │   │               ├── domains
        │   │               │   ├── dto
        │   │               │   │   ├── ContaCommand.java
        │   │               │   │   ├── DestinatarioCommand.java
        │   │               │   │   ├── GerarComprovanteCommand.java
        │   │               │   │   └── PagadorCommand.java
        │   │               │   ├── entity
        │   │               │   │   └── ComprovantePDF.java
        │   │               │   ├── exception
        │   │               │   │   ├── DomainException.java
        │   │               │   │   ├── Error.java
        │   │               │   │   ├── entity
        │   │               │   │   │   └── FormatacaoEntidadeException.java
        │   │               │   │   └── pdf
        │   │               │   │   │   ├── HeaderPdfException.java
        │   │               │   │   │   ├── ParticipantesInfoPdfException.java
        │   │               │   │   │   └── ValorPdfException.java
        │   │               │   └── gateway
        │   │               │   │   └── ComprovanteGateway.java
        │   │               ├── formatter
        │   │               │   ├── DateFormatter.java
        │   │               │   └── MoneyFormatter.java
        │   │               └── usecase
        │   │               │   └── GerarComprovante.java
        │   │           ├── inbound
        │   │               └── controller
        │   │               │   ├── ComprovantePDFController.java
        │   │               │   └── handler
        │   │               │       ├── ApiError.java
        │   │               │       └── RestExceptionHandler.java
        │   │           └── outbound
        │   │               └── itextpdf
        │   │                   ├── dto
        │   │                       ├── DocumentDTO.java
        │   │                       └── ParticipanteInfoDTO.java
        │   │                   ├── factory
        │   │                       ├── ColumnFactory.java
        │   │                       ├── DividerFactory.java
        │   │                       ├── DocumentFactory.java
        │   │                       ├── FontFactory.java
        │   │                       ├── ImageFactory.java
        │   │                       └── ParticipanteInfoFactory.java
        │   │                   ├── gateway
        │   │                       └── ComprovanteGatewayItextPDF.java
        │   │                   ├── property
        │   │                       ├── ColumnsTypePDF.java
        │   │                       ├── CustomColorsPDF.java
        │   │                       └── DividerTypePDF.java
        │   │                   └── strategy
        │   │                       ├── impressor
        │   │                           ├── ImpressorPDFNavigation.java
        │   │                           ├── ImpressorPDFStrategy.java
        │   │                           └── impl
        │   │                           │   ├── HeaderPDF.java
        │   │                           │   ├── ParticipantesInfoPDF.java
        │   │                           │   └── ValorPDF.java
        │   │                       └── template
        │   │                           ├── TemplatePDFNavigation.java
        │   │                           ├── TemplatePDFStrategy.java
        │   │                           └── impl
        │   │                               └── IdentificadorPDF.java
        └── resources
        │   ├── application.properties
        │   ├── fonts
        │       ├── MontserratBold.ttf
        │       └── MontserratRegular.ttf
        │   ├── images
        │       ├── backgroundValue.png
        │       └── logo.png
        │   └── pdf
    └── test
        └── java
            └── com
                └── poc
                    └── comprovantepdf
                        ├── ComprovantePDFApplicationTests.java
                        └── inbound
                            └── controller
                                └── ComprovantePDFControllerTest.java
```

# Modelo de Comprovante

![Comprovante](./doc/comprovante.png)
