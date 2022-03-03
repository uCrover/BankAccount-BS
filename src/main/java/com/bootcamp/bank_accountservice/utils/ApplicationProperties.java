package com.bootcamp.bank_accountservice.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class ApplicationProperties {

    @Value("${config.base.credit-card-service}")
    private String URLCreditCardService;

    @Value("${config.base.customer-service}")
    private String URLCustomerService;

    @Value("${config.base.credit-service}")
    private String URLCreditService;
}
