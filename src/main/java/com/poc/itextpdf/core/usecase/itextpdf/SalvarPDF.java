package com.poc.itextpdf.core.usecase.itextpdf;

import com.poc.itextpdf.core.domains.dto.GerarPDFCommand;
import com.poc.itextpdf.core.domains.gateway.RelatorioGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SalvarPDF {

    @Autowired
    RelatorioGateway relatorioGateway;

    public void execute (GerarPDFCommand command) {
        // Buscar informações do Redis, ilustradas no momento, como o recebimento de um command.
        var compras = command;

        // Mapear para os DTOs do PDF, não dessa forma, mas, utilizando um mapper
        var data = compras.formatar();

        // Gerar PDF (Minha Parte)
        var relatorioPDF = relatorioGateway.gerar(data);

        // Salvar no S3
        log.info("salvando no S3");
    }

}
