package com.poc.itextpdf.inbound.controller.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ApiError {

    private String code;

    private List<String> errors;

}
