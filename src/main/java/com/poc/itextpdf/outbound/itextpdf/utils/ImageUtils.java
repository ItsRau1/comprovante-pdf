package com.poc.itextpdf.outbound.itextpdf.utils;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.element.Image;
import lombok.SneakyThrows;

import java.net.URL;

@SuppressWarnings("java:S1118")
public class ImageUtils {

	@SneakyThrows
	public static Image getImage(URL path) {
		return new Image(ImageDataFactory.create(path));
	}

}
