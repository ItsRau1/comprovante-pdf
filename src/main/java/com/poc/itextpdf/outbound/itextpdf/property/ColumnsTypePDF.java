package com.poc.itextpdf.outbound.itextpdf.property;

import lombok.Getter;

@Getter
public enum ColumnsTypePDF {

    HEADER("header"), BODY("body"), FOOTER("footer");

    public final String value;

    ColumnsTypePDF(String column) {
        this.value = column;
    }

}
