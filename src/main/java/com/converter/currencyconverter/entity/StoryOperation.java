package com.converter.currencyconverter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "store_operation")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StoryOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String referenceCurrency;
    private String targetCurrency;
    private Double referenceAmount;
    private Double receivableAmount;
    private String date;
    private String login;

    public StoryOperation(
            String charCodeOnInput, String charCodeOnOutput,
            Double valueOfInputValute, Double valueOfOutputValute,
            String date, String login) {

        this.referenceCurrency = charCodeOnInput;
        this.targetCurrency = charCodeOnOutput;
        this.referenceAmount = valueOfInputValute;
        this.receivableAmount = valueOfOutputValute;
        this.date = date;
        this.login = login;
    }
}
