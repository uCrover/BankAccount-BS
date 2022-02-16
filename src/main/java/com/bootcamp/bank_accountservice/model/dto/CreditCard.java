package com.bootcamp.bank_accountservice.model.dto;

import lombok.Data;

@Data
public class CreditCard {
    private String id;
    private String nroCuenta;
    private String nroDocumento;
    private double saldo;
    private double limiteConsumo;
    private double cantidadConsumo;
}
