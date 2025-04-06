package com.poc.itextpdf.outbound.itextpdf.property;

import lombok.Getter;

@Getter
public enum CustomColorsPDF {

    FONT_COLOR("#292929");

    final String color;

    CustomColorsPDF(String color) {
        this.color = color;
    }

}
