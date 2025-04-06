package com.poc.itextpdf.outbound.itextpdf.factory;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.element.Image;
import lombok.SneakyThrows;

import java.net.URL;

@SuppressWarnings("java:S1118")
public class ImageFactory {

	@SneakyThrows
	public static Image generate(URL path) {
		return new Image(ImageDataFactory.create(path));
	}

}
