package com.poc.itextpdf.outbound.itextpdf.strategy.template;

import com.poc.itextpdf.core.domains.entity.ComprovantePDF;
import com.poc.itextpdf.outbound.itextpdf.dto.DocumentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TemplatePDFNavigation {

    private final List<TemplatePDFStrategy> templates;

    public void execute(DocumentDTO documentDTO, ComprovantePDF comprovante) {
        templates.forEach(template -> template.apply(documentDTO, comprovante));
    }

}
