package com.poc.itextpdf.core.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MoneyFormatter {

    public static String formatter (BigDecimal valor) {
        DecimalFormat decFormat = new DecimalFormat("#,###,##0.00");
        return decFormat.format(valor);
    }

}
