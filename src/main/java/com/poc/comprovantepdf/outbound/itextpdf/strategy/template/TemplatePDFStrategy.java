package com.poc.comprovantepdf.outbound.itextpdf.strategy.template;

import com.poc.comprovantepdf.core.domains.entity.ComprovantePDF;
import com.poc.comprovantepdf.outbound.itextpdf.dto.DocumentDTO;

public interface TemplatePDFStrategy {

	void apply(DocumentDTO documentDTO, ComprovantePDF comprovante);

}
