package com.poc.itextpdf.outbound.itextpdf.dto;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentDTO {

    private Document document;

    private PdfDocument pdfDocument;

}
