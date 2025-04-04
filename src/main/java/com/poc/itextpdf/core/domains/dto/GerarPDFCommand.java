package com.poc.itextpdf.core.domains.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GerarPDFCommand {

    private List<CompraCommand> compras;

    private String tipoRelatorio;

    private String dataInicio;

    private String dataFim;

    private String idRequisicao;

    public <E> GerarPDFCommand(GerarPDFCommand data, List<CompraCommand> compras) {
        this.compras = compras;
        this.tipoRelatorio = data.getTipoRelatorio();
        this.dataInicio = data.getDataInicio();
        this.dataFim = data.getDataFim();
        this.idRequisicao = data.getIdRequisicao();
    }

    public GerarPDFCommand formatar() {
        return this;
    };

}
