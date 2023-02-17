package com.converter.currencyconverter.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    @JacksonXmlProperty(isAttribute = true, localName = "ID")
    private String valuteId;
    @JacksonXmlProperty(isAttribute = true, localName = "NumCode")
    private String numCode;
    @JacksonXmlProperty(isAttribute = true, localName = "CharCode")
    private String charCode;
    @JacksonXmlProperty(isAttribute = true, localName = "Nominal")
    private String nominal;
    @JacksonXmlProperty(isAttribute = true, localName = "Name")
    private String name;
    @JacksonXmlProperty(isAttribute = true, localName = "Value")
    private String value;

    public String getValuteId() {
        return valuteId;
    }

    public void setValuteId(String valuteId) {
        this.valuteId = valuteId;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public String getNominal() {
        return nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }
}
