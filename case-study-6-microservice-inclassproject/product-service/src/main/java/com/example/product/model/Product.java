package com.example.product.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products", catalog = "rcon")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotNull(message = "name of product cannot be null")
    @Size(min = 1, max = 100, message = "name of product cannot be greater than 100 characters")
    private String name;

    @Column(name = "brand")
    @NotNull(message = "brand of product cannot be null")
    @Size(min = 1, max = 50, message = "brand name cannot be greater than 50 characters")
    private String brand;

    @Column(name = "description")
    @NotNull(message = "description of product cannot be null")
    @Size(min = 1, max = 500, message = "description of product cannot be more than 500 characters")
    private String description;

    @Column(name = "color")
    @NotNull(message = "color of product cannot be null")
    @Size(min = 1, max = 20, message = "name of the color cannot be greater than 20 characters")
    private String color;

    @Column(name = "category")
    @Size(min = 1, max = 20, message = "category of the product cannot be greater than 20 characters")
    private String category;

    @Column(name = "quantity")
    @NotNull
    @Size(min = 1)
    private Long quantity;

    @CreatedDate
    private Date createDate;

    @LastModifiedDate
    private Date modifiedDate;
}
