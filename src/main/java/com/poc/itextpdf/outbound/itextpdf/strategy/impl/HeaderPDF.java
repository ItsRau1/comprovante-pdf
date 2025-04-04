package com.poc.itextpdf.outbound.itextpdf.strategy.impl;

import com.itextpdf.kernel.color.WebColors;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.poc.itextpdf.core.domains.dto.GerarPDFCommand;
import com.poc.itextpdf.core.domains.exception.pdf.HeaderInfoPdfException;
import com.poc.itextpdf.outbound.itextpdf.factory.ColumnFactory;
import com.poc.itextpdf.outbound.itextpdf.factory.FontFactory;
import com.poc.itextpdf.outbound.itextpdf.property.ColorsPDF;
import com.poc.itextpdf.outbound.itextpdf.property.ColumnsTypePDF;
import com.poc.itextpdf.outbound.itextpdf.strategy.ImpressorPDFStrategy;
import com.poc.itextpdf.outbound.itextpdf.strategy.ImpressorOrder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HeaderPDF implements ImpressorPDFStrategy {

    @Override
    public void imprimir(Document document, GerarPDFCommand data) {
        Table table = new Table(ColumnFactory.generate(ColumnsTypePDF.HEADER_INFO));

        table.addCell(new Cell()
                .setMarginTop(8f)
                        .setBorder(Border.NO_BORDER)
                .setBorderLeft(new SolidBorder(WebColors.getRGBColor(ColorsPDF.BG_HEADER.getColor()), 1f) )
                .setPadding(0));

        table.addCell(new Cell().setMarginTop(5f)
                .setFontColor(WebColors.getRGBColor(ColorsPDF.HEADER_FONT.getColor()))
                .setHorizontalAlignment(HorizontalAlignment.LEFT)
                    .setPadding(0)
                    .setMargin(0)
                    .setMarginLeft(1f)
                    .setMarginBottom(-5f)
                    .setBorder(Border.NO_BORDER)
                .add(new Cell().add("Relatório")
                        .setFontSize(16f)
                        .setBorder(Border.NO_BORDER)
                        .setFont(FontFactory.generate("fonts/galanoGrotesqueAltBold.ttf"))
                        .setMarginTop(-16f)
                        .setPaddingBottom(-5f)
                ));

        document.add(table);
    }

    @Override
    public ImpressorOrder getOrdemImpressao() {
        return ImpressorOrder.HEADER;
    }

}
