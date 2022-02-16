package com.bootcamp.bank_accountservice.model.dto;

import lombok.Data;

@Data
public class Customer {
    private String _id;
    private String name;
    private String lastName;
    private String nroDocument;
    private String type;
    private String subType;
}
