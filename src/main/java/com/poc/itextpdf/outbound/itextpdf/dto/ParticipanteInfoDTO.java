package com.poc.itextpdf.outbound.itextpdf.dto;

import com.poc.itextpdf.core.domains.dto.ContaCommand;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParticipanteInfoDTO {

    private String title;

    private String nome;

    private ContaCommand conta;

    private String instituicao;

}
