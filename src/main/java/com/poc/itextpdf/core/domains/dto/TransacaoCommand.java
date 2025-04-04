package com.poc.itextpdf.core.domains.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransacaoCommand {

    private Integer id;

    private String data;

    private String hora;

    private String concessionaria;

    private String rota;

    private String praca;

    private VeiculoCommand veiculo;

    private BigDecimal valor;

    private String descricao;

    private Boolean valido;

}
