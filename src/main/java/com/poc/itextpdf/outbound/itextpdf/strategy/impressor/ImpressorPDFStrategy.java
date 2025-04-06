package com.poc.itextpdf.outbound.itextpdf.strategy.impressor;

import com.itextpdf.layout.Document;
import com.poc.itextpdf.core.domains.dto.GerarComprovanteCommand;

public interface ImpressorPDFStrategy {

	void imprimir(Document document, GerarComprovanteCommand data);

}
