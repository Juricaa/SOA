package com.gateway.gateway.controller;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping("test")
@Tag(name = "Conseiller", description = "Service conseiller")
public class Test {

    @GetMapping
    @Operation(summary = "list conseiller", description = "")
    public String getAllConseiller() {
        return "hello";
    }
}

