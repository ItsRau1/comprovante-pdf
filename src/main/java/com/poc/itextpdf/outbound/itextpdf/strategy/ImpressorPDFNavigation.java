package com.poc.itextpdf.outbound.itextpdf.strategy;

import com.itextpdf.layout.Document;
import com.poc.itextpdf.core.domains.dto.GerarComprovanteCommand;
import com.poc.itextpdf.core.domains.dto.GerarPDFCommand;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ImpressorPDFNavigation {

    private final ApplicationContext applicationContext;

    private final List<ImpressorPDFStrategy> impressors = new ArrayList<>();

    @PostConstruct
    void init() {
        impressors.addAll(applicationContext.getBeansOfType(ImpressorPDFStrategy.class).values());
        impressors.sort(ImpressorPDFStrategy::compareTo);
    }

    public void execute(Document document, GerarComprovanteCommand data) {
        this.impressors.forEach(impressor -> impressor.imprimir(document, data));
    }

}
