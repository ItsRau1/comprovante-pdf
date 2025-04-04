package com.poc.itextpdf.outbound.itextpdf.strategy.impl;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.poc.itextpdf.core.domains.dto.CompraCommand;
import com.poc.itextpdf.core.domains.dto.GerarComprovanteCommand;
import com.poc.itextpdf.core.domains.dto.GerarPDFCommand;
import com.poc.itextpdf.outbound.itextpdf.factory.ColumnFactory;
import com.poc.itextpdf.outbound.itextpdf.property.ColumnsTypePDF;
import com.poc.itextpdf.outbound.itextpdf.strategy.ImpressorOrder;
import com.poc.itextpdf.outbound.itextpdf.strategy.ImpressorPDFStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FooterPDF implements ImpressorPDFStrategy {
    @Override
    public void imprimir(Document document, GerarComprovanteCommand data) {
        Table table = new Table(ColumnFactory.generate(ColumnsTypePDF.FOOTER));

        document.add(table);
    }

    @Override
    public ImpressorOrder getOrdemImpressao() {
        return ImpressorOrder.FOOTER;
    }
}
