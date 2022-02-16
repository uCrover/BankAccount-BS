package com.bootcamp.bank_accountservice.service;

import com.bootcamp.bank_accountservice.model.dto.CreditCard;
import com.bootcamp.bank_accountservice.model.dto.Customer;
import com.bootcamp.bank_accountservice.model.entity.BankAccount;
import com.bootcamp.bank_accountservice.model.dto.ResponseBase;
import com.bootcamp.bank_accountservice.repository.IBanckAccountRepository;
import com.bootcamp.bank_accountservice.utils.ApplicationProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ServiceBankAccountImpl implements ServiceBankAccount{

    private final IBanckAccountRepository repository;

    private final ApplicationProperties properties;

    private WebClient webClient;

    /*public ServiceBankAccountImpl(){
        this.webClient= WebClient.builder().build();
    }*/

    @Override
    public Flux<BankAccount> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<BankAccount> findByNumAccount(String id) {
        return repository.findByNumBankAccount(id);
    }

    @Override
    public Mono<BankAccount> save(BankAccount bankAccount) {

        String typeClient="", subTypeClient="";

        Mono<Customer> customerMono=findCustomerNumDoc(bankAccount.getNumDoc());

        /*customerMono.flatMap(c -> {
            typeClient=c.getType();
        });*/

/*
    tipoCuenta
        ->Cuenta Corriente: CC
        ->Plazo Fijo:       PF
        ->Ahorro:           A
    saldo
        ->Pueden ingresar de una vez el saldo al generar el post()
* */

        /*buscar al cliente en el sistema
            "E" -> Empresarial <>
                -Solo puede abrir tipo "CC" (Cuenta corriente 1 o +)
                -flgMov=0 ->siempre es 0 --> amountMov=INFINITO
                -numTitulares>1
                -numFirmAutho>0
                -Subtipo:PYME
                    -> SI: comisionMant=0
                        ->verificar en CreditCardService mediante el nroDoc si está registrado o no
                    -> NO: comisionMant= número random, cobrado a fin de mes
            "P" -> Personal
                -verificar mediante findByNumDoc() si tiene o no. En caos que sí, F
                -Ahorro <> A
                    -> Subtipo: VIP
                        -verificar en CreditCardService mediante el nroDoc si está registrado o no
                        -Debe ingresar SALDO>0 al generar el post() <> monto mínimo de apertura x mes
                    -> comisionMant=0
                    -> amountMov= tiene un máximo de movMensuales
                    -> flgMov=1
                    -> SALDO puede ser 0 o no...en caso no lo ingrese, setear 0.

                -Cuenta Corriente
                    -> comisionMant=número random
                    -> flgMov=0 --> amountMov=INFINITO
                    -> SALDO puede ser 0 o no...en caso no lo ingrese, setear 0.

                -Plazo Fijo
                    -> comisionMant=0
                    -> flgMov=2 <> solo permite un movimiento de retiro o depósito en un día específico del mes.
                    ->amountMov <> varía por mes

        String typeCli="E" ;
        String subTipo="VIP";

        */

//consumimos y vemo qué tipo de cliente es
        String tipoCliente="E";
        String subTipo=null;
        String typeAcc=bankAccount.getTypeAccount();

        switch (tipoCliente){
            case "E": //raaaa
                if(typeAcc.equals("CC")){

                }else{
                    //rb.just("ra")
                    return Mono.empty();
                }
                break;
            case "P":

                break;
            default: ;
        }





        //numeroCuentaBancaria
        Integer digitCode1 = (int) (10000 * Math.random());
        Integer digitCode2 = (int) (10000 * Math.random());
        Integer digitCode3 = (int) (10000 * Math.random());
        Integer digitCode4 = (int) (10000 * Math.random());
        String nro_cuenta=digitCode1.toString()+"-"+digitCode2.toString()+"-"+digitCode3.toString()+"-"+digitCode4.toString();
        bankAccount.setNumBankAccount(nro_cuenta);

        //tipoCuentaBancaria
        String tipoCuentaBancaria =bankAccount.getNumBankAccount();
        String nomCuenta= " ";
        switch (tipoCuentaBancaria){
            case "A":
                nomCuenta ="Ahorros";
                break;
            case "CC":
                nomCuenta ="Cuenta Corriente";
                break;
            case "PF":
                nomCuenta ="Plazo Fijo";
                break;
        }
        bankAccount.setTypeAccount(nomCuenta);

        //saldo
        bankAccount.setSaldo(0);


        //En caso pase todas las validaciones se deberá:





        //return repository.save(bankAccount);
        return null;
    }

    @Override
    public Mono<BankAccount> update(BankAccount bankAccount) {
        return repository.save(bankAccount);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id).subscribe();
    }

    @Override
    public Mono<Customer> findCustomerNumDoc(String numDoc) {
       this.webClient=WebClient.builder().baseUrl(this.properties.getURLCustomerService()).build();

        Mono<Customer> customer=this.webClient
                                .get()
                                //.uri(this.properties.getURLCustomerService()+"/{id}",numDoc)
                .uri("{id}",numDoc)

                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Customer.class);

        return customer;
    }

    @Override
    public Mono<CreditCard> findCreditCardCustomer(String numDoc) {
        return null;
    }
}
