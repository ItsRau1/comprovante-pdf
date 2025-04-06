package com.poc.comprovantepdf.core.domains.exception.pdf;

import com.poc.comprovantepdf.core.domains.exception.DomainException;
import com.poc.comprovantepdf.core.domains.exception.Error;

public class HeaderPdfException extends DomainException {

	public HeaderPdfException() {
		super(Error.BAD_REQUEST, "Erro ao imprimir seção Header PDF");
	}

}
