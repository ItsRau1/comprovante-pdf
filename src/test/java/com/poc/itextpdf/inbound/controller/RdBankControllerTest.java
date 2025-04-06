package com.poc.itextpdf.inbound.controller;

import com.poc.itextpdf.core.domains.dto.ContaCommand;
import com.poc.itextpdf.core.domains.dto.DestinatarioCommand;
import com.poc.itextpdf.core.domains.dto.GerarComprovanteCommand;
import com.poc.itextpdf.core.domains.dto.PagadorCommand;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RdBankControllerTest {

	@LocalServerPort
	private int port;

	@BeforeEach
	public void setUp() {
		RestAssured.port = port;
	}

	@Test
	@Disabled
	@DisplayName("Deve ser possível gerar PDF leve")
	void deveSerPossivelGerarPdfLeve() {
		GerarComprovanteCommand command = GerarComprovanteCommand.builder()
			.valor(BigDecimal.ONE)
			.pagador(PagadorCommand.builder()
				.nome("Pagador")
				.conta(ContaCommand.builder().numero("1111111111-1111").instituicao("RDBank Financeira").build())
				.build())
			.destinatario(DestinatarioCommand.builder()
				.nome("Destinatario")
				.conta(ContaCommand.builder().numero("9999999999-9999").instituicao("RDBank Financeira").build())
				.build())
			.build();

		RestAssured.given()
			.log()
			.all()
			.contentType("application/json")
			.body(command)
			.when()
			.post("/rdbank/v1/gerar-comprovante")
			.then()
			.log()
			.all()
			.statusCode(HttpStatus.OK.value());
	}

}
