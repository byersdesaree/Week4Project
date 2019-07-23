package com.company.Week4Project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "processing_fee")
public class ProcessingFee {
    @Id
    @NotEmpty
    @Length(max = 20)
    private String productType;

    @NumberFormat(pattern = "#,###.##")
    private Double fee;

    public String getProcessingFee() {
        return productType;
    }

    public void setProcessingFee(String processingFee) {
        this.productType = processingFee;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }
}
