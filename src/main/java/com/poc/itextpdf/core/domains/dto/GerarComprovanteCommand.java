package com.poc.itextpdf.core.domains.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class GerarComprovanteCommand {

    private BigDecimal valor;

    private String data;

    private String hora;

    private PagadorCommand pagador;

    private DestinatarioCommand destinatario;

}
