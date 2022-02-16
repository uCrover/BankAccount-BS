package com.bootcamp.bank_accountservice.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseBase implements Serializable {
    private int code;
    private String msj;
}
