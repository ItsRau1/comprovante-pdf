package com.poc.comprovantepdf.outbound.itextpdf.gateway;

import com.poc.comprovantepdf.core.domains.dto.GerarComprovanteCommand;
import com.poc.comprovantepdf.core.domains.entity.ComprovantePDF;
import com.poc.comprovantepdf.core.domains.gateway.ComprovanteGateway;
import com.poc.comprovantepdf.outbound.itextpdf.dto.DocumentDTO;
import com.poc.comprovantepdf.outbound.itextpdf.factory.DocumentFactory;
import com.poc.comprovantepdf.outbound.itextpdf.strategy.impressor.ImpressorPDFNavigation;
import com.poc.comprovantepdf.outbound.itextpdf.strategy.template.TemplatePDFNavigation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Component
@Log4j2
@RequiredArgsConstructor
public class ComprovanteGatewayItextPDF implements ComprovanteGateway {

	@Autowired
	ImpressorPDFNavigation impressorPDFNavigation;

	@Autowired
	TemplatePDFNavigation templatePDFNavigation;

	@Override
	public void gerar(GerarComprovanteCommand command) {
		log.info("Iniciando geração do comprovante PDF. [COMMAND: {}]", command);
		ComprovantePDF comprovantePDF = new ComprovantePDF(command);
		log.info("Comprovante PDF gerado. [COMPROVANTE: {}]", comprovantePDF);
		log.info("Iniciando arquivo PDF do comprovante");
		DocumentDTO documentDTO = DocumentFactory.generate(comprovantePDF);
		impressorPDFNavigation.execute(documentDTO.getDocument(), command);
		templatePDFNavigation.execute(documentDTO, comprovantePDF);
		log.info("Finalizando arquivo PDF do comprovante");
		documentDTO.getDocument().close();
		log.info("Salvando arquivo PDF do comprovante: [Nome: {}]", comprovantePDF.getNomeArquivo());
		save(comprovantePDF);
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
