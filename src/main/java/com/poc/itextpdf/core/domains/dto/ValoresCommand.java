package com.poc.itextpdf.core.domains.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValoresCommand {

    private BigDecimal carregado;

    private BigDecimal utilizado;

    private BigDecimal debitoVpo;

}
