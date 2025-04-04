package com.poc.itextpdf.core.domains.gateway;

import com.poc.itextpdf.core.domains.dto.GerarPDFCommand;
import com.poc.itextpdf.core.domains.entity.RelatorioPDF;

public interface RelatorioGateway {

    RelatorioPDF gerar (GerarPDFCommand command);

}