package com.poc.comprovantepdf.outbound.itextpdf.strategy.impressor;

import com.itextpdf.layout.Document;
import com.poc.comprovantepdf.core.domains.dto.GerarComprovanteCommand;

public interface ImpressorPDFStrategy {

	void imprimir(Document document, GerarComprovanteCommand data);

}
