package com.poc.itextpdf.outbound.itextpdf.factory;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import com.poc.itextpdf.outbound.itextpdf.dto.ParticipanteInfoDTO;

public class ParticipanteInfoFactory {

    public static Cell generate (ParticipanteInfoDTO dto) {
        PdfFont fontBold = FontFactory.generate("fonts/MontserratBold.ttf");;
        return new Cell()
                .setTextAlignment(TextAlignment.LEFT)
                .setVerticalAlignment(VerticalAlignment.TOP)
                .setBorder(Border.NO_BORDER)
                .add(new Cell()
                        .setFont(fontBold)
                        .setFontSize(20f)
                        .setMarginTop(-16f)
                        .add(dto.getTitle())
                )
                .add(new Cell()
                        .setFont(fontBold)
                        .setFontSize(16f)
                        .setMarginTop(-10f)
                        .add("Nome")
                )
                .add(new Cell()
                        .setFontSize(24f)
                        .setMarginTop(-18f)
                        .add(dto.getNome())
                )
                .add(new Cell()
                        .setFont(fontBold)
                        .setFontSize(16f)
                        .setMarginTop(-10f)
                        .add("Conta")
                )
                .add(new Cell()
                        .setFontSize(24f)
                        .setMarginTop(-18f)
                        .add(dto.getConta().getNumero())
                )
                .add(new Cell()
                        .setFont(fontBold)
                        .setFontSize(16f)
                        .setMarginTop(-10f)
                        .add("Instituição")
                )
                .add(new Cell()
                        .setFontSize(24f)
                        .setMarginTop(-18f)
                        .add(dto.getConta().getInstituicao())
                );
    }

}
