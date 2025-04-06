package com.poc.itextpdf.inbound.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.itextpdf.core.domains.dto.GerarComprovanteCommand;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RdBankControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    @Disabled
    @DisplayName("Deve ser possível gerar PDF leve")
    void deveSerPossivelGerarPdfLeve() throws IOException {
                String sqsMessageTest = new String(Files.readAllBytes(Paths.get("src/test/resources/light.json")));
                ObjectMapper objectMapper = new ObjectMapper();
                var body = objectMapper.readValue(sqsMessageTest, GerarComprovanteCommand.class);

                RestAssured.given()
                        .log()
                        .all()
                        .contentType("application/json")
                        .body(body)
                        .when()
                        .post("/itextpdf/v1/criar-pdf-leve")
                        .then()
                        .log()
                        .all()
                        .statusCode(HttpStatus.OK.value());
    }

}
