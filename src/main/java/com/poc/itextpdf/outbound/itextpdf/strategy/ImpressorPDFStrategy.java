package com.poc.itextpdf.outbound.itextpdf.strategy;

import com.itextpdf.layout.Document;
import com.poc.itextpdf.core.domains.dto.GerarComprovanteCommand;
import com.poc.itextpdf.core.domains.dto.GerarPDFCommand;

public interface ImpressorPDFStrategy extends Comparable<ImpressorPDFStrategy> {

    void imprimir(Document document, GerarComprovanteCommand data);

    ImpressorOrder getOrdemImpressao();

    @Override
    default int compareTo(ImpressorPDFStrategy o) {
        return getOrdemImpressao().getOrdem().compareTo(o.getOrdemImpressao().getOrdem());
    }

}
