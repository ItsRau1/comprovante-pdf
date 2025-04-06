package com.poc.itextpdf.outbound.itextpdf.strategy.template;

import com.poc.itextpdf.core.domains.entity.ComprovantePDF;
import com.poc.itextpdf.outbound.itextpdf.dto.DocumentDTO;

public interface TemplatePDFStrategy {

	void apply(DocumentDTO documentDTO, ComprovantePDF comprovante);

}
