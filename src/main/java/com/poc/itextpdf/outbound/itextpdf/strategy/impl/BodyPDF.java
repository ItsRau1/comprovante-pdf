package com.poc.itextpdf.outbound.itextpdf.strategy.impl;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import com.poc.itextpdf.core.domains.dto.CompraCommand;
import com.poc.itextpdf.core.domains.dto.GerarComprovanteCommand;
import com.poc.itextpdf.core.domains.dto.GerarPDFCommand;
import com.poc.itextpdf.core.domains.exception.pdf.SumarioCompraPdfException;
import com.poc.itextpdf.core.utils.MoneyFormatter;
import com.poc.itextpdf.outbound.itextpdf.factory.ColumnFactory;
import com.poc.itextpdf.outbound.itextpdf.property.ColumnsTypePDF;
import com.poc.itextpdf.outbound.itextpdf.strategy.ImpressorPDFStrategy;
import com.poc.itextpdf.outbound.itextpdf.strategy.ImpressorOrder;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BodyPDF implements ImpressorPDFStrategy {

    @Override
    @SneakyThrows
    public void imprimir(Document document, GerarComprovanteCommand data) {
        // Criando a entidade "Table" fornecida pela lib passando como parâmetro o tamanho das colunas que definimos acima
        Table table = new Table(ColumnFactory.generate(ColumnsTypePDF.BODY));

        table.addCell(new Cell()
                .setTextAlignment(TextAlignment.LEFT)
                .setVerticalAlignment(VerticalAlignment.TOP)
                .setBorder(Border.NO_BORDER)
                .add(new Cell()
                        .setBold()
                        .setFontSize(20f)
                        .setMarginTop(-16f)
                        .add("Informações tranferencia")
                )
                .add(new Cell()
                        .setBold()
                        .setFontSize(16f)
                        .add("Valor")
                )
                .add(new Cell()
                        .setFontSize(24f)
                        .setMarginTop(-18f)
                        .add(String.format("R$ %s", MoneyFormatter.formatter(data.getValor())))
                )
                .add(new Cell()
                        .setBold()
                        .setFontSize(20f)
                        .add("Informações origem")
                )
                .add(new Cell()
                        .setBold()
                        .setFontSize(16f)
                        .add("Nome")
                )
                .add(new Cell()
                        .setFontSize(24f)
                        .setMarginTop(-18f)
                        .add(data.getPagador().getNome())
                )
                .add(new Cell()
                        .setBold()
                        .setFontSize(16f)
                        .add("Instituição")
                )
                .add(new Cell()
                        .setFontSize(24f)
                        .setMarginTop(-18f)
                        .add(data.getPagador().getConta().getBanco())
                )
        );

        table.addCell(new Cell());
        table.addCell(new Cell());

        // Adicionando a tabela ao nosso "Document" para enfim nosso PDF ser "montado"
        document.add(table);
    }

    @Override
    public ImpressorOrder getOrdemImpressao() {
        return ImpressorOrder.BODY;
    }

}
