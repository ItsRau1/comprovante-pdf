package com.poc.itextpdf.outbound.itextpdf.factory;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.util.Objects;

public class FontFactory {

	@SneakyThrows
	public static PdfFont generate(String pathFont) {
		InputStream inputStream = Objects
			.requireNonNull(FontFactory.class.getClassLoader().getResourceAsStream(pathFont));
		byte[] fontByte = IOUtils.toByteArray(inputStream);
		return PdfFontFactory.createFont(fontByte, PdfEncodings.IDENTITY_H, true);
	}

}
