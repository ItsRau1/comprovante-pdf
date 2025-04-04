package com.poc.itextpdf.outbound.itextpdf.strategy;

import lombok.Getter;

@Getter
public enum ImpressorOrder {

    HEADER(1), BODY(2), FOOTER(3);

    final Integer ordem;

    ImpressorOrder(int ordem) { this.ordem = ordem; }

}
