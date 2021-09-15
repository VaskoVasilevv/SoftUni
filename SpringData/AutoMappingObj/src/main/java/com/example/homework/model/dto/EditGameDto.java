package com.example.homework.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class EditGameDto {
    @Min(value = 0,message = "Invalid id for EditGameDto")
    private Long id;
    @Positive(message = "Invalid price for EditGameDto")
    private BigDecimal price;
    @Positive(message = "Invalid size for EditGameDto")
    private Double size;

    public EditGameDto() {
    }

    public EditGameDto(Long id, BigDecimal price, Double size) {
        this.id = id;
        this.price = price;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
