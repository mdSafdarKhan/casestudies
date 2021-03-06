package com.example.product.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    private Long id;

    @NotNull(message = "name of product cannot be null")
    @Size(min = 1, max = 100, message = "name of product cannot be greater than 100 characters")
    private String name;

    @NotNull(message = "brand of product cannot be null")
    @Size(min = 1, max = 50, message = "brand name cannot be greater than 50 characters")
    private String brand;

    @NotNull(message = "description of product cannot be null")
    @Size(min = 1, max = 500, message = "description of product cannot be more than 500 characters")
    private String description;

    @NotNull(message = "color of product cannot be null")
    @Size(min = 1, max = 20, message = "name of the color cannot be greater than 20 characters")
    private String color;

    @Size(min = 1, max = 20, message = "category of the product cannot be greater than 20 characters")
    private String category;

    @NotNull
    @Size(min = 1)
    private Long quantity;

    private Date createDate;

    private Date modifiedDate;
}
