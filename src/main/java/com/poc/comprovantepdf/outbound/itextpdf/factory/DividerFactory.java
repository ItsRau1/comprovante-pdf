package com.poc.comprovantepdf.outbound.itextpdf.factory;

import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.poc.comprovantepdf.outbound.itextpdf.property.DividerTypePDF;

public class DividerFactory {

	public static Cell generate(DividerTypePDF type) {
		return switch (type) {
			case DIVIDER:
				yield generateDivider(false);
			case DIVIDER_WITH_LINE:
				yield generateDivider(true);
		};
	}

	private static Cell generateDivider(Boolean line) {
		return new Cell().setBorder(Border.NO_BORDER).setBorderRight(line ? new SolidBorder(1f) : null);
	}

}
