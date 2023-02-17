package com.converter.currencyconverter.dto;

import lombok.Data;

@Data
public class HistoryResponse {

    private String referenceCurrency;
    private String targetCurrency;
    private Double referenceAmount;
    private Double receivableAmount;
    private String date;
}
