package com.poc.itextpdf.core.domains.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContaCommand {

	@NotBlank(message = "Número de conta é obrigatório")
	@Pattern(regexp = "^\\d{10}-\\d{4}$",
			message = "Número de conta mal fomatada, segue formato esperado: 9999999999-9999")
	private String numero;

	@NotBlank(message = "Instituição de conta é obrigatória")
	private String instituicao;

}
