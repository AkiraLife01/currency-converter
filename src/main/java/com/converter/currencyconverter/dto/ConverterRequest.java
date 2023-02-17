package com.converter.currencyconverter.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@Entity
public class ConverterRequest {

    @NonNull
    private String login;

    @NonNull
    private String charCodeOnInput;
    @NonNull
    private String charCodeOnOutput;
    @NonNull
    private Double amountOnInput;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public ConverterRequest() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
