package com.bootcamp.bank_accountservice.model.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "bank_account")
public class BankAccount {

    @Id
    private String numDoc;
    private String numBankAccount;
    private String typeAccount;
    private double saldo;
    private double comisionMant;
    //0:no tiene limite 1:si tiene limite
    private int flgMov;
    //cantidad de movimientos
    private int amountMov;
    //se aplica en caso supere el máximo de límite
    private double comisionLimitMov;
    /* solo válido para clientes empresariales */
    //1 o mas titulares
    private int numTitulares;
    //numero de firmantes autorizados 1 0 mas
    private int numFirmAutho;

}
