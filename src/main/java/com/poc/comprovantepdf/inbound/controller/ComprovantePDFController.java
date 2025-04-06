package com.poc.comprovantepdf.inbound.controller;

import com.poc.comprovantepdf.core.domains.dto.GerarComprovanteCommand;
import com.poc.comprovantepdf.core.usecase.GerarComprovante;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poc/v1")
@RequiredArgsConstructor
public class ComprovantePDFController {

	@Autowired
	private GerarComprovante gerarComprovante;

	@PostMapping(value = "/gerar-comprovante")
	public ResponseEntity<?> gerar(@Valid @RequestBody GerarComprovanteCommand command) {
		gerarComprovante.execute(command);
		return ResponseEntity.ok("Comprovante gerado com sucesso! Verifique a pasta 'resources/pdf'");
	}

}
