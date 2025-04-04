package com.poc.itextpdf.core.domains.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PagadorCommand {

    private String nome;

    private ContaCommand conta;

}
