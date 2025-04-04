package com.poc.itextpdf.outbound.itextpdf.strategy.impl;

import com.itextpdf.kernel.color.WebColors;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import com.poc.itextpdf.core.domains.dto.GerarComprovanteCommand;
import com.poc.itextpdf.core.domains.dto.GerarPDFCommand;
import com.poc.itextpdf.core.domains.exception.pdf.HeaderInfoPdfException;
import com.poc.itextpdf.outbound.itextpdf.factory.ColumnFactory;
import com.poc.itextpdf.outbound.itextpdf.factory.FontFactory;
import com.poc.itextpdf.outbound.itextpdf.property.ColorsPDF;
import com.poc.itextpdf.outbound.itextpdf.property.ColumnsTypePDF;
import com.poc.itextpdf.outbound.itextpdf.strategy.ImpressorPDFStrategy;
import com.poc.itextpdf.outbound.itextpdf.strategy.ImpressorOrder;
import com.poc.itextpdf.outbound.itextpdf.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Objects;

@Component
public class HeaderPDF implements ImpressorPDFStrategy {

    @Override
    public void imprimir(Document document, GerarComprovanteCommand data) {
        Table table = new Table(ColumnFactory.generate(ColumnsTypePDF.HEADER));

        String pathLogo = "images/logo.png";
        Image imgLogo = ImageUtils.getImage(Objects.requireNonNull(this.getClass().getClassLoader().getResource(pathLogo)))
                        .setWidth(275f)
                .setHorizontalAlignment(HorizontalAlignment.LEFT);

        table.addCell(new Cell()
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.LEFT)
                .setMarginBottom(40f)
                .add(imgLogo)
                .add(new Cell()
                        .setMarginTop(10f)
                        .add("RDBank Financeira SA.")
                )
                .add(new Cell()
                        .setMarginTop(-12f)
                        .add("CNPJ: 77.777.777/0001-77")
                )
                .add(new Cell()
                        .setMarginTop(-12f)
                        .add("contato@rdbank.com")
                )
                .add(new Cell()
                        .setMarginTop(-12f)
                        .add("0800 707 0707")
                )
        );

        table.addCell(new Cell()
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.LEFT)
                .add(new Cell()
                        .setBorder(Border.NO_BORDER)
                        .setBold()
                        .setFontSize(24f)
                        .setMarginTop(17f)
                        .add("Comprovante de Transferência"))
                .add(new Cell()
                        .setBorder(Border.NO_BORDER)
                        .setMarginLeft(5f)
                        .setMarginTop(-10f)
                        .add(String.format("Gerado em %s às %s", data.getData(), data.getHora())))
        );

        document.add(table);
    }

    @Override
    public ImpressorOrder getOrdemImpressao() {
        return ImpressorOrder.HEADER;
    }

}
