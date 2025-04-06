package com.poc.comprovantepdf.outbound.itextpdf.dto;

import com.poc.comprovantepdf.core.domains.dto.ContaCommand;
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
