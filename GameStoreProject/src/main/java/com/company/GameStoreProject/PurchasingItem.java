package com.company.GameStoreProject;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PurchasingItem {

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

    @NotEmpty
    @Length(max = 20)
    private String itemType;

    @NotNull
    private Integer itemId;

    @NotNull
    private Integer quantity;

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
