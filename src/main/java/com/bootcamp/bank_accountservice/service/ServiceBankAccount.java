package com.bootcamp.bank_accountservice.service;


import com.bootcamp.bank_accountservice.model.BankAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServiceBankAccount {

    public Flux<BankAccount> findAll();

    public Mono<BankAccount> findById(String id);

    public Mono<BankAccount> save(BankAccount bankAccount);

    public Mono<BankAccount> update(BankAccount bankAccount);

    public void delete(String id);
}
