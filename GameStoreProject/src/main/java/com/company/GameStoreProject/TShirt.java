package com.company.GameStoreProject;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "tshirt")

public class TShirt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tShirtId;


    @NotBlank
    @Length(max = 20)
    private String size;

    @NotBlank
    @Length(max = 20)
    private String color;

    @NotBlank
    @Length(max = 20)
    private String description;

    @NotNull

    private Double price;

    @NotNull

    private Integer quantity;



    public TShirt() {
    }

    public TShirt(Integer tShirtId, @NotBlank @Length(max = 20) String size, @NotBlank @Length(max = 20) String color, @NotBlank @Length(max = 20) String description, @NotNull Double price, @NotNull Integer quantity) {
        this.tShirtId = tShirtId;
        this.size = size;
        this.color = color;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer gettShirtId() {
        return tShirtId;
    }

    public void settShirtId(Integer tShirtId) {
        this.tShirtId = tShirtId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
