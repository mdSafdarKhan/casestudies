package com.example.orderservice.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders", catalog = "rcon")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Column(name = "fsn_id")
    private Long fsnId; //The unique identification of each SKU

    @Column(name = "order_date")
    private Date orderDate; //Date on which the order was placed

    /*Suppose you order 2 different products under the same order,
      it generates 2 different order Item IDs under the same order ID;
      orders are tracked by the Order Item ID.
    */
    @Column(name = "order_item_id")
    @NotNull(message = "order_item_id cannot be null")
    private Long orderItemId;

    @Column(name = "gmv")
    private Double gmv; //Gross Merchandise Value or Revenue

    @Column(name = "units")
    private Long units; //Number of units of the specific product sold

    @Column(name = "order_payment_type")
    private String orderPaymentType;    //How the order was paid – prepaid or cash on delivery

    @Column(name = "sla")
    private Integer sla; //Number of days it typically takes to deliver the product

    @Column(name = "customer_id")
    private Integer customerId;  //Unique identification of a customer

    @Column(name = "product_mrp")
    private String productMRP;

    @CreatedDate
    private Date createDate;

    @LastModifiedDate
    private Date modifiedDate;
}
