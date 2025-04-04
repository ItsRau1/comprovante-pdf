package com.poc.itextpdf.outbound.itextpdf.property;

import lombok.Getter;

@Getter
public enum ColorsPDF {

    BG_HEADER("#A3A3A3"), HEADER_FONT("#681DB4"), FONT_COLOR("#292929"), FONT_BOLD_COLOR("#3d3d3d");

    private final String color;

    ColorsPDF(String color) {
        this.color = color;
    }

}
