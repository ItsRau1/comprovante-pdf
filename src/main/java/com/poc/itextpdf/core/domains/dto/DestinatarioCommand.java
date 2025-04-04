package com.poc.itextpdf.core.domains.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DestinatarioCommand {

    private String nome;

    private ContaCommand conta;

}
