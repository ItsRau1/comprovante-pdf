package com.poc.comprovantepdf.outbound.itextpdf.strategy.impressor;

import com.itextpdf.layout.Document;
import com.poc.comprovantepdf.core.domains.dto.GerarComprovanteCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component
@RequiredArgsConstructor
public class ImpressorPDFNavigation {

	private final List<ImpressorPDFStrategy> impressors;

	public void execute(Document document, GerarComprovanteCommand data) {
		log.info("Inciando impressão de informações no documento PDF");
		this.impressors.forEach(impressor -> impressor.imprimir(document, data));
		log.info("Finalizando impressão de informações no documento PDF");
	}

}
