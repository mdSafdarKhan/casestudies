package com.example.orderservice.dto;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {

    public Long orderId;
    public Long fsnId; //The unique identification of each SKU
    public Long orderItemId;
    public Double gmv; //Gross Merchandise Value or Revenue
    public Long units; //Number of units of the specific product sold
    public String orderPaymentType;    //How the order was paid – prepaid or cash on delivery
    public Integer sla; //Number of days it typically takes to deliver the product
    public Integer customerId;  //Unique identification of a customer
    public String productMRP;
}
