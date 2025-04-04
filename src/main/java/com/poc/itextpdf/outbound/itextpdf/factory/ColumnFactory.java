package com.poc.itextpdf.outbound.itextpdf.factory;

import com.poc.itextpdf.outbound.itextpdf.property.ColumnsTypePDF;
import com.poc.itextpdf.outbound.itextpdf.property.ColumnsSizePDF;

public class ColumnFactory {

    public static float[] generate (ColumnsTypePDF column) {
        return switch (column) {
            case FULL_WIDTH:
                yield generateFullWidth();
            case HEADER_INFO:
                yield generateHeaderInfo();
            case SUMARIO_COMPRA:
                yield generateSumarioCompra();
        };
    }

    static float[] generateFullWidth () {
        return new float[] { ColumnsSizePDF._770.getValue() };
    }

    static float[] generateHeaderInfo () {
        return new float[] { ColumnsSizePDF._35.getValue(), ColumnsSizePDF._1.getValue(), ColumnsSizePDF._120.getValue(), ColumnsSizePDF._614.getValue() };
    }

    static float[] generateSumarioCompra() {
        return new float[] { ColumnsSizePDF._32.getValue(), ColumnsSizePDF._738.getValue() };
    }

}
