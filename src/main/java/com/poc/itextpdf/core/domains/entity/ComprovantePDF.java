package com.poc.itextpdf.core.domains.entity;

import com.poc.itextpdf.core.domains.dto.GerarComprovanteCommand;
import com.poc.itextpdf.core.domains.exception.entity.FormatacaoEntidadeException;
import com.poc.itextpdf.core.formatter.DateFormatter;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.io.ByteArrayOutputStream;
import java.util.Optional;
import java.util.UUID;

@Getter
@Log4j2
public class ComprovantePDF extends ByteArrayOutputStream {

	private final String PATH = "src/main/resources/pdf";

	private final String nomeArquivo;

	private String identificador;

	public ComprovantePDF(GerarComprovanteCommand command) {
		this.nomeArquivo = String.format("%s/%s.pdf", this.PATH, generateNomeArquivo(command));
		this.generateIdentificador();
	}

	private String generateNomeArquivo(GerarComprovanteCommand command) {
		var nomePagador = Optional.of(command.getPagador().getNome().trim().replace(" ", "-").toUpperCase())
			.orElseThrow(() -> new FormatacaoEntidadeException(this.getClass().getName()));
		var data = Optional.ofNullable(command.getData())
			.orElseThrow(() -> new FormatacaoEntidadeException(this.getClass().getName()));
		var formatedDate = DateFormatter.formatTimeStamp(data);

		return String.format("RDBANK-%s-%s", nomePagador, formatedDate);
	}

	public void generateIdentificador() {
		this.identificador = UUID.randomUUID().toString();
	}

}
