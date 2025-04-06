package com.poc.itextpdf.core.domains.gateway;

import com.poc.itextpdf.core.domains.dto.GerarComprovanteCommand;
import com.poc.itextpdf.core.domains.entity.ComprovantePDF;

public interface ComprovanteGateway {

    ComprovantePDF gerar (GerarComprovanteCommand command);

}