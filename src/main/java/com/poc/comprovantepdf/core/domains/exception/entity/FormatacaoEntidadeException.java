package com.poc.comprovantepdf.core.domains.exception.entity;

import com.poc.comprovantepdf.core.domains.exception.DomainException;
import com.poc.comprovantepdf.core.domains.exception.Error;

public class FormatacaoEntidadeException extends DomainException {

	public FormatacaoEntidadeException(String entidade) {
		super(Error.BAD_REQUEST, String.format("Erro na formatação de informação na entidade: %s", entidade));
	}

}
