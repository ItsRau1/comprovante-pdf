package com.poc.itextpdf.core.domains.exception.pdf;

import com.poc.itextpdf.core.domains.exception.DomainException;
import com.poc.itextpdf.core.domains.exception.Error;

public class ParticipantesInfoPdfException extends DomainException {

	public ParticipantesInfoPdfException() {
		super(Error.BAD_REQUEST, "Erro ao imprimir seção Participante Info PDF");
	}

}
