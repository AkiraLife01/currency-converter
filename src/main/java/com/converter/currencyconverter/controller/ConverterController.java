package com.converter.currencyconverter.controller;

import com.converter.currencyconverter.dto.ConverterRequest;
import com.converter.currencyconverter.dto.ConverterResponse;
import com.converter.currencyconverter.service.ConverterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/converter")
public class ConverterController {

    private final ConverterService converterService;

    public ConverterController(ConverterService converterService) {
        this.converterService = converterService;
    }

    @PostMapping("/get-quote")
    public ConverterResponse getConvertedQuote(@RequestBody @NonNull ConverterRequest converterRequest)
            throws JsonProcessingException {

        return converterService.getConvertedQuote(converterRequest);
    }
}
