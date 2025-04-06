package com.poc.itextpdf.core.domains.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DestinatarioCommand {

    @NotBlank(message = "Nome do destinatário é obrigatório")
    private String nome;

    @NotNull(message = "Conta do destinatário é obrigatória")
    @Valid
    private ContaCommand conta;

}
