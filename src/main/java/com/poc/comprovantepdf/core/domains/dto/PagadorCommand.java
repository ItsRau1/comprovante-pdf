package com.poc.comprovantepdf.core.domains.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PagadorCommand {

	@NotBlank(message = "Nome do pagador é obrigatório")
	private String nome;

	@NotNull(message = "Conta do pagador é obrigatória")
	@Valid
	private ContaCommand conta;

}
