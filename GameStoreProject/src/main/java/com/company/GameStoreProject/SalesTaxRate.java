package com.company.GameStoreProject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "sales_tax_rate")
public class SalesTaxRate {

    @Id
    @NotBlank
    @Length(max = 2)
    private String state;

    @NotNull
    private Double rate;

    public String getState() {
        return state;
    }

    public Double getRate() {
        return rate;
    }
}
