package com.company.GameStoreProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CreateInvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @RequestMapping(value = "/gameStore/purchase", method = RequestMethod.POST)
    public Invoice calculateInvoice(@RequestBody @Valid PurchasingItem purchasingItem){
        Invoice invoice;
        invoice = invoiceService.calculateInvoiceFromPurchasingItem(purchasingItem);
       // String s = invoiceService.calculateInvoiceFromPurchasingItem(purchasingItem);
        return invoice;

    }
}
