package com.poc.itextpdf.outbound.itextpdf.gateway;

import com.poc.itextpdf.core.domains.dto.GerarComprovanteCommand;
import com.poc.itextpdf.core.domains.entity.ComprovantePDF;
import com.poc.itextpdf.core.domains.gateway.ComprovanteGateway;
import com.poc.itextpdf.outbound.itextpdf.dto.DocumentDTO;
import com.poc.itextpdf.outbound.itextpdf.factory.DocumentFactory;
import com.poc.itextpdf.outbound.itextpdf.strategy.impressor.ImpressorPDFNavigation;
import com.poc.itextpdf.outbound.itextpdf.strategy.template.TemplatePDFNavigation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Component
@RequiredArgsConstructor
public class ComprovanteGatewayItextPDF implements ComprovanteGateway {

	@Autowired
	ImpressorPDFNavigation impressorPDFNavigation;

	@Autowired
	TemplatePDFNavigation templatePDFNavigation;

	@Override
	public ComprovantePDF gerar(GerarComprovanteCommand command) {
		// Gerando RelatorioPDF utilizando os dados recebidos como parâmetro
		ComprovantePDF comprovantePDF = new ComprovantePDF(command);

		// Gerando o Document (Para mais detalhes, vide a Factory)
		DocumentDTO documentDTO = DocumentFactory.generate(comprovantePDF);

		// Imprimindo dados no PDF
		impressorPDFNavigation.execute(documentDTO.getDocument(), command);

		templatePDFNavigation.execute(documentDTO, comprovantePDF);

		// 'Fechando' o 'Document' finalizando a sua 'montagem'
		documentDTO.getDocument().close();

		// "Escrevendo" nosso arquivo para efeitos de teste TODO: Este passo deve ser
		// removido
		save(comprovantePDF);

		// Retornando o RelatorioPDF que acabamos de gerar
		return comprovantePDF;
	}

	public void save(ComprovantePDF comprovantePDF) {

		try (OutputStream outputStream = new FileOutputStream(comprovantePDF.getNomeArquivo())) {
			comprovantePDF.writeTo(outputStream);
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

}
