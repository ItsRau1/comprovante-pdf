package com.poc.itextpdf.outbound.itextpdf.strategy.impressor.impl;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.poc.itextpdf.core.domains.dto.GerarComprovanteCommand;
import com.poc.itextpdf.core.domains.exception.pdf.ValorPdfException;
import com.poc.itextpdf.core.formatter.MoneyFormatter;
import com.poc.itextpdf.outbound.itextpdf.factory.ColumnFactory;
import com.poc.itextpdf.outbound.itextpdf.factory.FontFactory;
import com.poc.itextpdf.outbound.itextpdf.factory.ImageFactory;
import com.poc.itextpdf.outbound.itextpdf.property.ColumnsTypePDF;
import com.poc.itextpdf.outbound.itextpdf.strategy.impressor.ImpressorPDFStrategy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

@Component
@Order(2)
public class ValorPDF implements ImpressorPDFStrategy {

    private final PdfFont fontBold = FontFactory.generate("fonts/MontserratBold.ttf");

    @Override
    public void imprimir(Document document, GerarComprovanteCommand command) {
        Table table = new Table(ColumnFactory.generate(ColumnsTypePDF.FULL_WIDTH));

        table.addCell(generateBackgroundLabelValor());

        table.addCell(generateLabelValor());

        BigDecimal valor = Optional.ofNullable(command.getValor()).orElseThrow(ValorPdfException::new);
        table.addCell(generateValor(valor));

        document.add(table);
    }

    private Cell generateBackgroundLabelValor() {
        String pathLogo = "images/backgroundValue.png";
        Image imgLogo = ImageFactory.generate(Objects.requireNonNull(this.getClass().getClassLoader().getResource(pathLogo)))
                .setWidth(106f)
                .setHorizontalAlignment(HorizontalAlignment.CENTER);

        return new Cell()
                .setMarginTop(-50f)
                .setBorder(Border.NO_BORDER)
                .add(imgLogo);
    }

    private Cell generateLabelValor() {
        return new Cell()
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginTop(-58f)
                .setFontSize(24f)
                .setFontColor(Color.WHITE)
                .setFont(fontBold)
                .add("Valor");
    }

    private Cell generateValor(BigDecimal value) {
        return new Cell()
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginTop(-30f)
                .setFontSize(36f)
                .setFont(fontBold)
                .add(MoneyFormatter.formatter(value));
    }

}
