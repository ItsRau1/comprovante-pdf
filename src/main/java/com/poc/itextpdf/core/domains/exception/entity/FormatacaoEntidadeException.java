package com.poc.itextpdf.core.domains.exception.entity;

import com.poc.itextpdf.core.domains.exception.DomainException;
import com.poc.itextpdf.core.domains.exception.Error;

public class FormatacaoEntidadeException extends DomainException {

    public FormatacaoEntidadeException(String entidade) {
        super(Error.BAD_REQUEST, String.format("Erro na formatação de informação na entidade: %s", entidade));
    }

}
