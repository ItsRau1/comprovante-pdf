package com.poc.comprovantepdf.core.usecase;

import com.poc.comprovantepdf.core.domains.dto.GerarComprovanteCommand;
import com.poc.comprovantepdf.core.domains.gateway.ComprovanteGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class GerarComprovante {

	@Autowired
	ComprovanteGateway comprovanteGateway;

	public void execute(GerarComprovanteCommand command) {
		log.info("Gerando comprovante [COMMAND: {}]", command);
		comprovanteGateway.gerar(command);
		log.info("Comprovante gerado");
	}

}
