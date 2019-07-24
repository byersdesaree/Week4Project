package com.company.GameStoreProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@RestController
public class CreateInvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    InvoiceRepository invoiceRepo;

    @Autowired
    processingFeeRepository processingFeeRepo;

    @Autowired
    Service invoiceServiceGames;

    @RequestMapping(value = "/gameStore/purchase", method = RequestMethod.POST)
    public Invoice calculateInvoice(@RequestBody @Valid Invoice invoice){


//return invoice.getItemType();
            invoiceService.calculateInvoiceFromPurchasingItem(invoice);


        return invoice;


    }

    @RequestMapping(value = "/gameStore/invoice", method = RequestMethod.GET)
    public List<Invoice> calculateInvoice(){


        // String s = invoiceService.calculateInvoiceFromPurchasingItem(purchasingItem);
        return invoiceRepo.findAll();

    }
}
