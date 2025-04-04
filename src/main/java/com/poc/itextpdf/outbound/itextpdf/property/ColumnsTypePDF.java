package com.poc.itextpdf.outbound.itextpdf.property;

import lombok.Getter;

@Getter
public enum ColumnsTypePDF {

    FULL_WIDTH("fullWidth"), HEADER_INFO("headerInfo"), SUMARIO_COMPRA("sumarioCompra");

    public final String value;

    ColumnsTypePDF(String column) {
        this.value = column;
    }

}
