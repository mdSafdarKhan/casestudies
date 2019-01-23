package com.example.storeservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "stores", catalog = "rcon")
public class Store {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeId;

    private String storeName;

    private String email;

    private Long contactNumber;

    private Long pickupLocation;

    private String address;

    private Long gstinNumber;

    @CreatedDate
    private Date createDate;

    @LastModifiedDate
    private Date modifiedDate;
}
