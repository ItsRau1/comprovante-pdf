package com.poc.itextpdf.core.domains.exception.pdf;

import com.poc.itextpdf.core.domains.exception.DomainException;
import com.poc.itextpdf.core.domains.exception.Error;

public class ValorPdfException extends DomainException {

	public ValorPdfException() {
		super(Error.BAD_REQUEST, "Erro ao imprimir seção Valor PDF");
	}

}
