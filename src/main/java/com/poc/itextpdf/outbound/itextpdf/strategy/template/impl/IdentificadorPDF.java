package com.poc.itextpdf.outbound.itextpdf.strategy.template.impl;

import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import com.poc.itextpdf.core.domains.entity.ComprovantePDF;
import com.poc.itextpdf.outbound.itextpdf.dto.DocumentDTO;
import com.poc.itextpdf.outbound.itextpdf.factory.FontFactory;
import com.poc.itextpdf.outbound.itextpdf.strategy.template.TemplatePDFStrategy;
import org.springframework.stereotype.Component;

@Component
public class IdentificadorPDF implements TemplatePDFStrategy {

    @Override
    public void apply(DocumentDTO documentDTO, ComprovantePDF comprovante) {
        int numberOfPages = documentDTO.getPdfDocument().getNumberOfPages();

        Paragraph identificador = new Paragraph();
        identificador.add(new Text("Identificador: ").setFont(FontFactory.generate("fonts/MontserratBold.ttf")));
        identificador.add(comprovante.getIdentificador());

        for (int i = 1; i <= numberOfPages; i++) {
            documentDTO.getDocument().showTextAligned(identificador,
                    421, 24, i, TextAlignment.CENTER, VerticalAlignment.BOTTOM, 0);
        }
    }

}
