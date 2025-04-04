package com.poc.itextpdf.outbound.itextpdf.property;

import lombok.Getter;

@Getter
public enum ColumnsSizePDF {

    _1(1.0f), _5(5.0f), _32(32.0f), _35(35.0f), _120(120.0f), _614(614.0f), _738(738.0f), _770(770.0f);

    final float value;

    ColumnsSizePDF(float space) {
        this.value = space;
    }

}
