package com.bootcamp.bank_accountservice.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Credit {
    private String _id;
    private String code;
    private String numDocument;
    private double total;
    private double amortization;
    private LocalDate dateLapsed;
}
