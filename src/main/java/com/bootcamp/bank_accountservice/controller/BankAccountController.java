package com.bootcamp.bank_accountservice.controller;

import com.bootcamp.bank_accountservice.model.dto.Customer;
import com.bootcamp.bank_accountservice.model.entity.BankAccount;
import com.bootcamp.bank_accountservice.service.ServiceBankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bank_account")
public class BankAccountController {

    private final ServiceBankAccount service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<BankAccount> getAllBankAccounts(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<BankAccount> getBankAccount(@PathVariable ("id") String id){
        return service.findByNumAccount(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BankAccount> saveBankAccount(@RequestBody BankAccount bankAccount){
        return this.service.save(bankAccount);
    }

    @PutMapping
    public Mono<BankAccount> updateBankAccount(@RequestBody BankAccount bankAccount){
        return service.update(bankAccount);
    }

    @DeleteMapping("/{id}")
    public void deleteBankAccount(@PathVariable ("id") String id){
        service.delete(id);
    }

    @GetMapping("/customer/{id}")
    public Mono<Customer> getCustomer(@PathVariable ("id") String id){
        return this.service.findCustomerNumDoc(id);
    }

}
