package com.bootcamp.bank_accountservice.controller;

import com.bootcamp.bank_accountservice.model.BankAccount;
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
    public Flux<BankAccount> getBankAccount(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<BankAccount> getBankAccount(@PathVariable ("id") String id){
        return service.findById(id);
    }

    @PostMapping
    public Mono<BankAccount> saveBankAccount(@RequestBody BankAccount bankAccount){
        return service.save(bankAccount);
    }

    @PutMapping
    public Mono<BankAccount> updateBankAccount(@RequestBody BankAccount bankAccount){
        return service.update(bankAccount);
    }

    @DeleteMapping("/{id}")
    public void deleteBankAccount(@PathVariable ("id") String id){
        service.delete(id);
    }

}
