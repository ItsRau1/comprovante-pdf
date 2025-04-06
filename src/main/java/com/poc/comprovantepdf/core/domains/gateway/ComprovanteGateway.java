package com.poc.comprovantepdf.core.domains.gateway;

import com.poc.comprovantepdf.core.domains.dto.GerarComprovanteCommand;

public interface ComprovanteGateway {

	void gerar(GerarComprovanteCommand command);

}