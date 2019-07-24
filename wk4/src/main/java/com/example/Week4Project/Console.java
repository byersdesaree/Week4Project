package com.example.Week4Project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Console")
public class Console {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotEmpty
    @Length (max = 11)
    private int consoleId;
    @NotEmpty
    @Length(max = 50)
    private String model;
    @NotEmpty
    @Length(max = 50)
    private String manufacturer;
    @NotEmpty
    @Length(max = 20)
    private String memoryAmount;
    @NotEmpty
    @Length(max = 20)
    private String processor;
    @NotEmpty
    @NumberFormat(pattern = "#####.##")
    private double price;
    @NotEmpty
    @Length(max = 11)
    private int quantity;

    public int getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(int consoleId) {
        this.consoleId = consoleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
