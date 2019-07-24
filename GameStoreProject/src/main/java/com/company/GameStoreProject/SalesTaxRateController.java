package com.company.GameStoreProject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class SalesTaxRateController {

    @Autowired
    SalesTaxRateRepository salesTaxRateRepo;
    @Autowired
    processingFeeRepository processingFeeRepo;

    @RequestMapping(value = "/salesTax/{state}", method = RequestMethod.GET)
    public SalesTaxRate calculateInvoice(@PathVariable String state)
    {
        SalesTaxRate salesTaxRate = salesTaxRateRepo.findByState(state);
        return salesTaxRate;
    }

    @RequestMapping(value = "/fee/{type}", method = RequestMethod.GET)
    public processingFee getFee(@PathVariable String type)
    {
        processingFee fee = processingFeeRepo.findByProductType(type);
        return fee;
    }
}
