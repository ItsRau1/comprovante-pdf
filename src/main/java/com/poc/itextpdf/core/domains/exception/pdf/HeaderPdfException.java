package com.poc.itextpdf.core.domains.exception.pdf;

import com.poc.itextpdf.core.domains.exception.DomainException;
import com.poc.itextpdf.core.domains.exception.Error;

public class HeaderPdfException extends DomainException {

	public HeaderPdfException() {
		super(Error.BAD_REQUEST, "Erro ao imprimir seção Header PDF");
	}

}
