package com.company.GameStoreProject;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer invoice_id;
    @NotEmpty
    @Length(max = 80)
    private String name;
    @NotEmpty
    @Length(max = 30 )
    private String street;
    @NotEmpty
    @Length(max = 30)
    private String city;
    @NotEmpty
    @Length(min = 2, max = 2)
    private String state;
    //validate by state code
    @NotEmpty
    @Length(max = 30 )
    private String zipcode;
    //validate with parseInt
    public Integer getInvoice_id() {
        return invoice_id;
    }
    public void setInvoice_id(Integer invoice_id) {
        this.invoice_id = invoice_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public String getItemType() {
        return itemType;
    }
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    public Integer getItemId() {
        return itemId;
    }
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
    public Double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    public Double getTax() {
        return tax;
    }
    public void setTax(Double tax) {
        this.tax = tax;
    }
    public Double getProcessingFee() {
        return processingFee;
    }
    public void setProcessingFee(Double processingFee) {
        this.processingFee = processingFee;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    @NotEmpty
    @Length(max = 20)
    private String itemType;
    @NotNull
    private Integer itemId;
    @NotNull
    private Double unitPrice;
    @NotNull
    private Integer quantity;
    @NotNull
    private Double subtotal;
    @NotNull
    private Double tax;
    @NotNull
    private Double processingFee;
    @NotNull
    private Double total;


}
