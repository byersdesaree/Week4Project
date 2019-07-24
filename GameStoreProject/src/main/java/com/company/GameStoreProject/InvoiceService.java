package com.company.GameStoreProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;

@Component
public class InvoiceService {

    @Autowired
    TShirtRepository tShirtRepo;
    @Autowired
    SalesTaxRateRepository salesTaxRateRepo;
    @Autowired
    processingFeeRepository processingFeeRepo;


    public Invoice calculateInvoiceFromPurchasingItem(PurchasingItem purchasingItem) {
        //throw new IllegalArgumentException("I am able to execute here");


        String S;

        Invoice invoice = new Invoice();
        Double salesTax = 0.0, processingFee = 0.0;
        copyPurchasingItemIntoInvoice(invoice, purchasingItem);
//
//        S = purchasingItem.getState() + "-" + purchasingItem.getQuantity().toString()+ "-"
//                + purchasingItem.getCity()+ "-"+
//                purchasingItem.getQuantity().toString() + "-"+
//                purchasingItem.getState()+ "-"+
//                purchasingItem.getItemType()+ "-" +
//                purchasingItem.getItemId().toString()+ "-"+
//                purchasingItem.getName();
//
//        S+="\n";
//        S+=         invoice.getState() + "-" + invoice.getQuantity().toString()+ "-"
//                + invoice.getCity()+ "-"+
//                invoice.getQuantity().toString() + "-"+
//                invoice.getState()+ "-"+
//                invoice.getItemType()+ "-" +
//                invoice.getItemId().toString()+ "-"+
//                invoice.getName();


        TShirt tShirt = tShirtRepo.getOne((purchasingItem.getItemId()));


        //SalesTaxRate salesTaxRate = salesTaxRateRepo.findByState("AL");






        invoice.setUnitPrice(tShirt.getPrice());


        int found = 0;


        for (processingFee processingFee1 : processingFeeRepo.findAll()) {
            if (processingFee1.getProductType().toLowerCase().equals(invoice.getItemType().toLowerCase()))
                found = 1;
        }


        if (found == 0)
            throw new IllegalArgumentException("Item doesn't match - T-Shirts, Games, Consoles ");


            if (invoice.getQuantity() > 0) {
                if (invoice.getQuantity() > tShirt.getQuantity()) {
                    throw new IllegalArgumentException("Quantity specified not available in the Inventory, " +
                            "Quantity Avbl: " + tShirt.getQuantity());
                }


                invoice.setSubtotal(invoice.getUnitPrice() * invoice.getQuantity());
                tShirt.setQuantity(tShirt.getQuantity() - invoice.getQuantity());
                tShirtRepo.save(tShirt);

            } else
                throw new IllegalArgumentException("Quantity should be greater than zero");
        // if(purchasingItem.getQuantity() < tShirt.getQuantity()

//        if(purchasingItem.getState().equals("AL"))
//            return  S+"\n"+ "from tshirt->"+tShirt.getColor();


        found =0;
        for (SalesTaxRate sales : salesTaxRateRepo.findAll()) {
            if (sales.getState().toLowerCase().equals(invoice.getState().toLowerCase()))
                found = 1;
        }
        if (found == 0)
            throw new IllegalArgumentException("Invalid State name entered");

        found =0;


        SalesTaxRate salesTaxRate = salesTaxRateRepo.getOne(purchasingItem.getState());


        salesTax = invoice.getSubtotal() * salesTaxRate.getRate();
        if (invoice.getQuantity() > 10)
            processingFee = processingFeeRepo.findByProductType(invoice.getItemType()).getFee() + 15.49;

        else
            processingFee = processingFeeRepo.findByProductType(invoice.getItemType()).getFee();

        invoice.setTax(salesTax);
        invoice.setProcessingFee(processingFee);
        invoice.setTotal(invoice.getSubtotal()+ processingFee + salesTax);


        //return invoice;

        return invoice;
    }

    public void copyPurchasingItemIntoInvoice(Invoice invoice, PurchasingItem purchasingItem) {


        invoice.setName(purchasingItem.getName());
        invoice.setStreet(purchasingItem.getStreet());
        invoice.setCity(purchasingItem.getCity());
        invoice.setState(purchasingItem.getState());
        invoice.setZipcode(purchasingItem.getZipcode());
        invoice.setItemType(purchasingItem.getItemType());
        invoice.setItemId(purchasingItem.getItemId());
        invoice.setQuantity(purchasingItem.getQuantity());
    }
}
