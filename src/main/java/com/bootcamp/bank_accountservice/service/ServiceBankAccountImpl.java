package com.bootcamp.bank_accountservice.service;

import com.bootcamp.bank_accountservice.model.BankAccount;
import com.bootcamp.bank_accountservice.repository.IBanckAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ServiceBankAccountImpl implements ServiceBankAccount{

    private final IBanckAccountRepository repository;

    @Override
    public Flux<BankAccount> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<BankAccount> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<BankAccount> save(BankAccount bankAccount) {
        //numeroCuentaBancaria
        Integer digitCode1 = (int) (10000 * Math.random());
        Integer digitCode2 = (int) (10000 * Math.random());
        Integer digitCode3 = (int) (10000 * Math.random());
        Integer digitCode4 = (int) (10000 * Math.random());
        String nro_cuenta=digitCode1.toString()+"-"+digitCode2.toString()+"-"+digitCode3.toString()+"-"+digitCode4.toString();
        bankAccount.setNumCuentaBancaria(nro_cuenta);

        //tipoCuentaBancaria
        String tipoCuentaBancaria =bankAccount.getNumCuentaBancaria();
        String nomCuenta= " ";
        switch (tipoCuentaBancaria){
            case "A":
                nomCuenta ="Ahorros";
                break;
            case "CC":
                nomCuenta ="CuentaCorriente";
                break;
            case "PF":
                nomCuenta ="PlazoFijo";
                break;
        }
        bankAccount.setTip_cue_bancaria(nomCuenta);
        //saldo
        bankAccount.setSaldo(0);
        //
        //TipoCliente
        String tipoCliente=bankAccount.getNroDocumento();
        Integer digiOFND = tipoCliente.length();
        switch (digiOFND){
            case 8:
                tipoCliente ="P";
                break;
            case 11:
                tipoCliente ="E";
                break;
        }
        bankAccount.setTipo_cliente(tipoCliente);


        return repository.save(bankAccount);
    }

    @Override
    public Mono<BankAccount> update(BankAccount bankAccount) {
        return repository.save(bankAccount);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id).subscribe();
    }
}
