package com.poc.itextpdf.outbound.itextpdf.factory;

import com.itextpdf.kernel.color.WebColors;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.poc.itextpdf.core.domains.entity.RelatorioPDF;
import com.poc.itextpdf.outbound.itextpdf.property.ColorsPDF;

public class DocumentFactory {

    public static Document generate(RelatorioPDF relatorioPDF) {
        // 1. Gerando um "PdfWriter" de PDF com base na entidade que acabamos de gerar para conseguirmos "montar" PDF
        var pdfWriter = new PdfWriter(relatorioPDF);

        // 2. Gerando um "PdfDocument" utilizando o "escritor" que acabamos de gerar
        var pdfDocument = new PdfDocument(pdfWriter);

        // 3. Gerando um "Document" utiizando o "PdfDocument" que acabamos de gerar, e definindo tamanho e orientação das páginas do PDF
        Document document = new Document(pdfDocument, PageSize.A4.rotate());

        // 4. Adicionando especificações gerais do documento, como fonte, margem, etc...
        document.setMargins(24f, 24f, 24f, 24f);
        document.setFontSize(12f);
        document.setCharacterSpacing(0.1f);
        document.setFont(FontFactory.generate("fonts/Montserrat.ttf"));
        document.setFontColor(WebColors.getRGBColor(ColorsPDF.FONT_COLOR.getColor()));

        // 5. Retornando "DocumentPdfDTO"
        return document;
    }

}
