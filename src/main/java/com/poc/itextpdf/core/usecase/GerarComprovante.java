package com.poc.itextpdf.core.usecase;

import com.poc.itextpdf.core.domains.dto.GerarComprovanteCommand;
import com.poc.itextpdf.core.domains.gateway.ComprovanteGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GerarComprovante {

	@Autowired
	ComprovanteGateway comprovanteGateway;

	public void execute(GerarComprovanteCommand command) {
		comprovanteGateway.gerar(command);
	}

}
