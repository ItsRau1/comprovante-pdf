package com.poc.itextpdf.outbound.itextpdf.property;

import lombok.Getter;

@Getter
public enum ColumnsTypePDF {

	FULL_WIDTH("fullWidth"), HALF("half"), HALF_DIVIDER("halfDivider");

	final String value;

	ColumnsTypePDF(String column) {
		this.value = column;
	}

}
