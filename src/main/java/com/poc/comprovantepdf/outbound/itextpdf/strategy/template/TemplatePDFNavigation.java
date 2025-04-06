package com.poc.comprovantepdf.outbound.itextpdf.strategy.template;

import com.poc.comprovantepdf.core.domains.entity.ComprovantePDF;
import com.poc.comprovantepdf.outbound.itextpdf.dto.DocumentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component
@RequiredArgsConstructor
public class TemplatePDFNavigation {

	private final List<TemplatePDFStrategy> templates;

	public void execute(DocumentDTO documentDTO, ComprovantePDF comprovante) {
        log.info("Inciando aplicação de templates no documento PDF");
        templates.forEach(template -> template.apply(documentDTO, comprovante));
        log.info("Finalizando aplicação de templates no documento PDF");
	}

}
