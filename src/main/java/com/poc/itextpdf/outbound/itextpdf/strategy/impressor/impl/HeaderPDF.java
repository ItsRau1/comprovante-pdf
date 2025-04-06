package com.poc.itextpdf.outbound.itextpdf.strategy.impressor.impl;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.poc.itextpdf.core.domains.dto.GerarComprovanteCommand;
import com.poc.itextpdf.core.formatter.DateFormatter;
import com.poc.itextpdf.outbound.itextpdf.factory.ColumnFactory;
import com.poc.itextpdf.outbound.itextpdf.factory.FontFactory;
import com.poc.itextpdf.outbound.itextpdf.factory.ImageFactory;
import com.poc.itextpdf.outbound.itextpdf.property.ColumnsTypePDF;
import com.poc.itextpdf.outbound.itextpdf.strategy.impressor.ImpressorPDFStrategy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
@Order(1)
public class HeaderPDF implements ImpressorPDFStrategy {

	@Override
	public void imprimir(Document document, GerarComprovanteCommand command) {
		Table table = new Table(ColumnFactory.generate(ColumnsTypePDF.HALF));

		table.addCell(generateBancoInfo());
		table.addCell(generateComprovanteInfo(command.getData()));

		document.add(table);
	}

	private Cell generateBancoInfo() {
		String pathLogo = "images/logo.png";
		Image imgLogo = ImageFactory
			.generate(Objects.requireNonNull(this.getClass().getClassLoader().getResource(pathLogo)))
			.setWidth(275f)
			.setHorizontalAlignment(HorizontalAlignment.LEFT);

		return new Cell().setBorder(Border.NO_BORDER)
			.setTextAlignment(TextAlignment.LEFT)
			.setMarginBottom(40f)
			.add(imgLogo)
			.add(new Cell().setMarginTop(10f).add("RDBank Financeira SA."))
			.add(new Cell().setMarginTop(-12f).add("CNPJ: 77.777.777/0001-77"))
			.add(new Cell().setMarginTop(-12f).add("contato@rdbank.com"))
			.add(new Cell().setMarginTop(-12f).add("0800 707 0707"));
	}

	private Cell generateComprovanteInfo(LocalDateTime date) {
		return new Cell().setBorder(Border.NO_BORDER)
			.setTextAlignment(TextAlignment.LEFT)
			.setMarginLeft(-10f)
			.add(new Cell().setBorder(Border.NO_BORDER)
				.setFont(FontFactory.generate("fonts/MontserratBold.ttf"))
				.setFontSize(24f)
				.setMarginTop(17f)
				.add("Comprovante de Transferência"))
			.add(new Cell().setBorder(Border.NO_BORDER)
				.setMarginLeft(5f)
				.setMarginTop(-10f)
				.add(String.format("Gerado em %s às %s", DateFormatter.formatDate(date),
						DateFormatter.formatHour(date))));
	}

}
