package com.poc.comprovantepdf.outbound.itextpdf.strategy.impressor.impl;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.poc.comprovantepdf.core.domains.dto.DestinatarioCommand;
import com.poc.comprovantepdf.core.domains.dto.GerarComprovanteCommand;
import com.poc.comprovantepdf.core.domains.dto.PagadorCommand;
import com.poc.comprovantepdf.core.domains.exception.pdf.ParticipantesInfoPdfException;
import com.poc.comprovantepdf.outbound.itextpdf.dto.ParticipanteInfoDTO;
import com.poc.comprovantepdf.outbound.itextpdf.factory.ColumnFactory;
import com.poc.comprovantepdf.outbound.itextpdf.factory.DividerFactory;
import com.poc.comprovantepdf.outbound.itextpdf.factory.ParticipanteInfoFactory;
import com.poc.comprovantepdf.outbound.itextpdf.property.ColumnsTypePDF;
import com.poc.comprovantepdf.outbound.itextpdf.property.DividerTypePDF;
import com.poc.comprovantepdf.outbound.itextpdf.strategy.impressor.ImpressorPDFStrategy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Order(3)
public class ParticipantesInfoPDF implements ImpressorPDFStrategy {

	@Override
	public void imprimir(Document document, GerarComprovanteCommand data) {
		Table table = new Table(ColumnFactory.generate(ColumnsTypePDF.HALF_DIVIDER));

		PagadorCommand pagador = Optional.ofNullable(data.getPagador()).orElseThrow(ParticipantesInfoPdfException::new);
		table.addCell(generatePagadorInfo(pagador));

		table.addCell(DividerFactory.generate(DividerTypePDF.DIVIDER_WITH_LINE));

		DestinatarioCommand destinatario = Optional.ofNullable(data.getDestinatario())
			.orElseThrow(ParticipantesInfoPdfException::new);
		table.addCell(generateDestinatarioInfo(destinatario));

		document.add(table);
	}

	private Cell generatePagadorInfo(PagadorCommand pagador) {
		return ParticipanteInfoFactory.generate(ParticipanteInfoDTO.builder()
			.title("Informações origem")
			.nome(pagador.getNome())
			.conta(pagador.getConta())
			.build());
	}

	private Cell generateDestinatarioInfo(DestinatarioCommand destinatario) {
		return ParticipanteInfoFactory
			.generate(ParticipanteInfoDTO.builder()
				.title("Informações destino")
				.nome(destinatario.getNome())
				.conta(destinatario.getConta())
				.build())
			.setMarginLeft(24f);
	}

}
