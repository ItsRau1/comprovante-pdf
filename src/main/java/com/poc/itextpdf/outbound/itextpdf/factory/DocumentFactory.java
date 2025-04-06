package com.poc.itextpdf.outbound.itextpdf.factory;

import com.itextpdf.kernel.color.WebColors;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.poc.itextpdf.core.domains.entity.ComprovantePDF;
import com.poc.itextpdf.outbound.itextpdf.dto.DocumentDTO;
import com.poc.itextpdf.outbound.itextpdf.property.CustomColorsPDF;

public class DocumentFactory {

    public static DocumentDTO generate(ComprovantePDF comprovantePDF) {
        var pdfWriter = new PdfWriter(comprovantePDF);
        var pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument, PageSize.A4.rotate());
        document.setMargins(24f, 14f, 24f, 24f);
        document.setFontSize(12f);
        document.setCharacterSpacing(0.1f);
        document.setFont(FontFactory.generate("fonts/MontserratRegular.ttf"));
        document.setFontColor(WebColors.getRGBColor(CustomColorsPDF.FONT_COLOR.getColor()));
        return DocumentDTO
                .builder()
                .document(document)
                .pdfDocument(pdfDocument)
                .build();
    }

}
