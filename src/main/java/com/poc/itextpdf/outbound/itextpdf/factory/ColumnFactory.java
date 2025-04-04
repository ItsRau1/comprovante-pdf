package com.poc.itextpdf.outbound.itextpdf.factory;

import com.poc.itextpdf.outbound.itextpdf.property.ColumnsTypePDF;
import com.poc.itextpdf.outbound.itextpdf.property.ColumnsSizePDF;

public class ColumnFactory {

    public static float[] generate (ColumnsTypePDF column) {
        return switch (column) {
            case HEADER:
                yield generateHeader();
            case BODY:
                yield generateBody();
            case FOOTER:
                yield generateFooter();
        };
    }

    static float[] generateHeader () {
        return new float[] { 421.0f, 421.0f };
    }

    static float[] generateBody () {
        return new float[] { 420.5f, 1f, 420.5f };
    }

    static float[] generateFooter() {
        return new float[] { ColumnsSizePDF._32.getValue(), ColumnsSizePDF._738.getValue() };
    }

}
