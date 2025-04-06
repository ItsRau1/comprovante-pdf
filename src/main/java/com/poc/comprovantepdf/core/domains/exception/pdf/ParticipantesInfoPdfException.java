package com.poc.comprovantepdf.core.domains.exception.pdf;

import com.poc.comprovantepdf.core.domains.exception.DomainException;
import com.poc.comprovantepdf.core.domains.exception.Error;

public class ParticipantesInfoPdfException extends DomainException {

	public ParticipantesInfoPdfException() {
		super(Error.BAD_REQUEST, "Erro ao imprimir seção Participante Info PDF");
	}

}
