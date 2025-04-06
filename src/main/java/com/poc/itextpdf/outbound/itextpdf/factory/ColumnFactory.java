package com.poc.itextpdf.outbound.itextpdf.factory;

import com.poc.itextpdf.outbound.itextpdf.property.ColumnsTypePDF;

public class ColumnFactory {

    public static float[] generate (ColumnsTypePDF column) {
        return switch (column) {
            case FULL_WIDTH:
                yield generateFullWidth();
            case HALF:
                yield generateHalf();
            case HALF_DIVIDER:
                yield generateHalfDivider();
        };
    }

    static float[] generateFullWidth() {
        return new float[] { 842f };
    }

    static float[] generateHalf () {
        return new float[] { 421.0f, 421.0f };
    }

    static float[] generateHalfDivider () {
        return new float[] { 420.5f, 1.0f, 420.5f };
    }

}
