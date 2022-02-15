package com.bootcamp.bank_accountservice.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "bank_account")
public class BankAccount {

    @Id
    private String nroDocumento;
    private String numCuentaBancaria;
    private String tip_cue_bancaria;
    private int saldo;
    private int comision_mantenimiento;
    //0:no tiene limite 1:si tiene limite
    private int flg_mov;
    private Long can_movimientos;
    //personal o empresarial
    private String tipo_cliente;
    //1 o mas titulares
    private int nro_titulares;
    //numero de firmantes autorizados 1 0 mas
    private int nro_fir_aut;

}
