package com.poc.itextpdf.outbound.itextpdf.strategy.impl;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.*;
import com.poc.itextpdf.core.domains.dto.CompraCommand;
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
    public void imprimir(Document document, GerarPDFCommand data) {
        // Construindo PDF com dados

        // Criando a entidade "Table" fornecida pela lib passando como parâmetro o tamanho das colunas que definimos acima
        Table table = new Table(ColumnFactory.generate(ColumnsTypePDF.SUMARIO_COMPRA));

        CompraCommand compra = Optional.of(data.getCompras().get(0)).orElseThrow(SumarioCompraPdfException::new);

        Text separador = new Text(" - ");

        Paragraph sumario = new Paragraph()
                .add(new Text("Auditoria Veloe").setBold())
                .add(separador)
                .add(new Text("Embarcador ").setBold())
                .add(new Text(compra.getEmbarcador()))
                .add(separador)
                .add(new Text("ID ").setBold())
                .add(new Text(compra.getId().toString()))
                .add(separador)
                .add(new Text("Valor carregado (R$) ").setBold())
                .add(new Text(MoneyFormatter.formatter(compra.getValores().getCarregado())));

        table.addCell(new Cell()
                .setBorder(Border.NO_BORDER)
                .setMarginTop(-40f)
                .add(sumario)
        );

        // Adicionando a tabela ao nosso "Document" para enfim nosso PDF ser "montado"
        document.add(table);
    }

    @Override
    public ImpressorOrder getOrdemImpressao() {
        return ImpressorOrder.BODY;
    }

}
