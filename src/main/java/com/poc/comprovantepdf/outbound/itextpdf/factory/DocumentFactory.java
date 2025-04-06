package com.poc.comprovantepdf.outbound.itextpdf.factory;

import com.itextpdf.kernel.color.WebColors;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.poc.comprovantepdf.core.domains.entity.ComprovantePDF;
import com.poc.comprovantepdf.outbound.itextpdf.dto.DocumentDTO;
import com.poc.comprovantepdf.outbound.itextpdf.property.CustomColorsPDF;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DocumentFactory {

	public static DocumentDTO generate(ComprovantePDF comprovantePDF) {
		log.info("Iniciando geração do documento PDF");
		var pdfWriter = new PdfWriter(comprovantePDF);
		var pdfDocument = new PdfDocument(pdfWriter);
		Document document = new Document(pdfDocument, PageSize.A4.rotate());
		log.info("Adicionando estilizações padrão para o PDF");
		document.setMargins(24f, 14f, 24f, 24f);
		document.setFontSize(12f);
		document.setCharacterSpacing(0.1f);
		document.setFont(FontFactory.generate("fonts/MontserratRegular.ttf"));
		document.setFontColor(WebColors.getRGBColor(CustomColorsPDF.FONT_COLOR.getColor()));
		log.info("Retornando estrutura de documento PDF");
		return DocumentDTO.builder().document(document).pdfDocument(pdfDocument).build();
	}

}
