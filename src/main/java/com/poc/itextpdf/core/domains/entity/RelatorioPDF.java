package com.poc.itextpdf.core.domains.entity;

import com.poc.itextpdf.core.domains.dto.GerarComprovanteCommand;
import com.poc.itextpdf.core.domains.dto.GerarPDFCommand;
import com.poc.itextpdf.core.domains.exception.entity.FormatacaoEntidadeException;
import com.poc.itextpdf.core.domains.gateway.RelatorioGateway;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.io.ByteArrayOutputStream;

@Getter
@Log4j2
public class RelatorioPDF extends ByteArrayOutputStream {

    private String nomeArquivo;

    public RelatorioPDF(GerarPDFCommand command) {
        try {
            // Com o conjunto de dados recebido, vamos tratar os dados para definir a propriedade "nomeArquivo"
            var tipoRelatorio = command.getTipoRelatorio().toUpperCase();
            var dataInicio = command.getDataInicio().replace("-", "");
            var dataFim = command.getDataFim().replace("-", "");
            var idRequisicao = command.getIdRequisicao();
            // Com todos os dados tratados agora vamos definir a propriedade "nomeArquivo"
            this.nomeArquivo = String.format("VPO-%s-de-%s-a-%s-%s.pdf", tipoRelatorio, dataInicio, dataFim, idRequisicao);
        } catch (Exception exception) {
            log.error(exception);
            throw new FormatacaoEntidadeException("RelatorioPDF");
        }
    }

    public RelatorioPDF(GerarComprovanteCommand command) {}

}
