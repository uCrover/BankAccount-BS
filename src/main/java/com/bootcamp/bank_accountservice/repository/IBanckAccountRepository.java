package com.bootcamp.bank_accountservice.repository;


import com.bootcamp.bank_accountservice.model.entity.BankAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface IBanckAccountRepository extends ReactiveMongoRepository<BankAccount,String> {

    Flux<BankAccount>  findByNumDoc (String numDoc);

    Mono<BankAccount> findByNumBankAccount (String numBankAccount);
}
