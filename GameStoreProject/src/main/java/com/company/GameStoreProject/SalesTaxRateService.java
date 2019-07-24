package com.company.GameStoreProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalesTaxRateService {

    @Autowired
    SalesTaxRateRepository salesTaxRateRepo;

    public SalesTaxRate getSalesTaxRateByState(String state){
        return salesTaxRateRepo.findByState(state);
    }
}
