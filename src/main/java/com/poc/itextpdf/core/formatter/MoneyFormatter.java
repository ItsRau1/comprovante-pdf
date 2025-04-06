package com.poc.itextpdf.core.formatter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class MoneyFormatter {

    private static final Locale LOCAL_BRASIL = new Locale("pt", "BR");

    public static String formatter (BigDecimal valor) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(LOCAL_BRASIL);
        return formatter.format(valor);
    }

}
