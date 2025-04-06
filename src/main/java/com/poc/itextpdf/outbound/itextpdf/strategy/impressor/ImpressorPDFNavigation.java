package com.poc.itextpdf.outbound.itextpdf.strategy.impressor;

import com.itextpdf.layout.Document;
import com.poc.itextpdf.core.domains.dto.GerarComprovanteCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ImpressorPDFNavigation {

    private final List<ImpressorPDFStrategy> impressors;

    public void execute(Document document, GerarComprovanteCommand data) {
        this.impressors.forEach(impressor -> impressor.imprimir(document, data));
    }

}
