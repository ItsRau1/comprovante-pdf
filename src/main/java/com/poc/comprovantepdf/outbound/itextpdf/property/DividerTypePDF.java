package com.poc.comprovantepdf.outbound.itextpdf.property;

import lombok.Getter;

@Getter
public enum DividerTypePDF {

	DIVIDER("divider"), DIVIDER_WITH_LINE("dividerWithLine");

	final String value;

	DividerTypePDF(String value) {
		this.value = value;
	}

}
