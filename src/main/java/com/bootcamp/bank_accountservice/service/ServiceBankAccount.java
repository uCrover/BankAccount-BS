package com.bootcamp.bank_accountservice.service;


import com.bootcamp.bank_accountservice.model.dto.Credit;
import com.bootcamp.bank_accountservice.model.dto.CreditCard;
import com.bootcamp.bank_accountservice.model.dto.Customer;
import com.bootcamp.bank_accountservice.model.entity.BankAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServiceBankAccount {

    public Flux<BankAccount> findAll();

    public Mono<BankAccount> findByNumAccount(String numAccount);

    public Mono<BankAccount> save(BankAccount bankAccount);

    public Mono<BankAccount> update(BankAccount bankAccount);

    public void delete(String id);

    public Mono<Customer> findCustomerNumDoc(String numDoc);

    public Mono<CreditCard> findCreditCardCustomer (String numDoc);

    public Mono<Credit> findCreditLapsed(String numDoc);
}
