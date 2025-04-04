package com.poc.itextpdf.inbound.controller;

import com.poc.itextpdf.core.domains.dto.GerarPDFCommand;
import com.poc.itextpdf.core.domains.exception.DomainException;
import com.poc.itextpdf.core.usecase.itextpdf.SalvarPDF;
import com.poc.itextpdf.inbound.controller.handler.ApiError;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/itextpdf/v1")
@RequiredArgsConstructor
public class ItextPdfController {

    @Autowired
    private SalvarPDF criarPdfLeve;

    @PostMapping(value = "/gerar-pdf")
    public ResponseEntity<?> criar (@RequestBody GerarPDFCommand command) {
        criarPdfLeve.execute(command);
        return ResponseEntity.ok("PDF Gerado com sucesso!");
    }

}
