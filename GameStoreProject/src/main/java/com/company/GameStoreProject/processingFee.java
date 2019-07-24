package com.company.GameStoreProject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "processing_fee")
public class processingFee {

    @Id
    @NotEmpty
    @Length(max = 20)
    private String productType;

    private Double fee;

    public String getProductType() {
        return productType;
    }

    public Double getFee() {
        return fee;
    }
}
