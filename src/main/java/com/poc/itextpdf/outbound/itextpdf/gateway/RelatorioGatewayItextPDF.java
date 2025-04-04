package com.poc.itextpdf.outbound.itextpdf.gateway;

import com.itextpdf.layout.Document;
import com.poc.itextpdf.core.domains.dto.GerarComprovanteCommand;
import com.poc.itextpdf.core.domains.dto.GerarPDFCommand;
import com.poc.itextpdf.core.domains.entity.RelatorioPDF;
import com.poc.itextpdf.core.domains.gateway.RelatorioGateway;
import com.poc.itextpdf.outbound.itextpdf.factory.DocumentFactory;
import com.poc.itextpdf.outbound.itextpdf.strategy.ImpressorPDFNavigation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

@Component
@RequiredArgsConstructor
public class RelatorioGatewayItextPDF implements RelatorioGateway {

    @Autowired
    ImpressorPDFNavigation impressorPDFNavigation;

    @Override
    public RelatorioPDF gerar(GerarComprovanteCommand command) {
        // Gerando RelatorioPDF utilizando os dados recebidos como parâmetro
        RelatorioPDF relatorioPDF = new RelatorioPDF(command);

        // Gerando o Document (Para mais detalhes, vide a Factory)
        Document document = DocumentFactory.generate(relatorioPDF);

        // Imprimindo dados no PDF
        impressorPDFNavigation.execute(document, command);

        // 'Fechando' o 'Document' finalizando a sua 'montagem'
        document.close();

        // "Escrevendo" nosso arquivo para efeitos de teste TODO: Este passo deve ser removido
        save(relatorioPDF);

        // Retornando o RelatorioPDF que acabamos de gerar
        return relatorioPDF;
    }

    public void save(RelatorioPDF relatorioPDF) {
        try {
            File file = new File("src/test/resources/pdf/test.pdf");
            OutputStream out = new FileOutputStream(file);
            out.write(relatorioPDF.toByteArray());
        } catch (Exception ignore) {}

    }

}
