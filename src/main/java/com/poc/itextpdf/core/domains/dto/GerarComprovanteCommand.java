package com.poc.itextpdf.core.domains.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class GerarComprovanteCommand {

	@NotNull(message = "Valor do comprovante é obrigatório")
	@DecimalMin(value = "0.0", inclusive = false)
	private BigDecimal valor;

	@NotNull(message = "Pagador é obrigatório")
	@Valid
	private PagadorCommand pagador;

	@NotNull(message = "Destinatario é obrigatório")
	@Valid
	private DestinatarioCommand destinatario;

	@JsonIgnore
	private final LocalDateTime data = LocalDateTime.now();

}
