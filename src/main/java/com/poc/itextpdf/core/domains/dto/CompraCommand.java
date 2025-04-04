package com.poc.itextpdf.core.domains.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompraCommand {

    private Integer id;

    private String data;

    private String hora;

    private String embarcador;

    private String rota;

    private String origem;

    private String destino;

    private VeiculoCommand veiculo;

    private ValoresCommand valores;

    private List<TransacaoCommand> transacoes;

}
