package com.poc.itextpdf.core.domains.exception.pdf;

import com.poc.itextpdf.core.domains.exception.DomainException;
import com.poc.itextpdf.core.domains.exception.Error;

public class SumarioCompraPdfException extends DomainException {

    public SumarioCompraPdfException() {
        super(Error.BAD_REQUEST,
                "Erro ao imprimir seção Sumário Compra PDF");
    }

}
