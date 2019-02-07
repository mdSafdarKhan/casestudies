package com.example.orderservice.service;

import com.example.orderservice.controller.OrderController;
import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.exception.OrderNotCreatedException;
import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

	private static final Logger log = LoggerFactory.getLogger(OrderService.class);
	
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    RestTemplate restTemplate;

    public Order createOrder(OrderDTO orderDTO){
    	log.info("inside createOrder");
        //TODO We must be having timeout
        //TODO Circuit breaking

        String productUrl = "http://localhost:8081/api/product/productId/" + orderDTO.getOrderItemId();
        //String productUrl = "http://product-service/api/product/productId/" + orderDTO.getOrderItemId();
        ResponseEntity<Object> productServiceResponse = restTemplate.getForEntity(productUrl, Object.class);

        /*TODO switch (responseEntity.getStatusCode()){
            case OK:
            case CREATED:
            case CONFLICT:
                //do the remediate
                //send back to UI a different formatter model-view
                //send a meaningful error message to UI
        }*/

        if(productServiceResponse.getBody() != null){
            System.out.println("Product found going to create order");
            Order order = Order.builder()
                    .createDate(new Date())
                    .customerId(orderDTO.getCustomerId())
                    .fsnId(orderDTO.getFsnId())
                    .gmv(orderDTO.getGmv())
                    .modifiedDate(new Date())
                    .orderDate(new Date())
                    .orderItemId(orderDTO.getOrderItemId())
                    .orderPaymentType(orderDTO.getOrderPaymentType())
                    .productMRP(orderDTO.getProductMRP())
                    .sla(orderDTO.getSla())
                    .units(orderDTO.getUnits())
                    .build();
            return orderRepository.save(order);
        }
        else{
            throw new OrderNotCreatedException();
        }
    }

    public Optional<Order> getByOrderId(Long orderId){
        return orderRepository.findById(orderId);
    }

    public boolean updateOrder(OrderDTO orderDTO){
        Optional<Order> optionalOrder = orderRepository.findById(orderDTO.getOrderId());
        if(optionalOrder != null){
            System.out.println("found order to be updated");
            Order order = optionalOrder.get();
            order.setCustomerId(orderDTO.getCustomerId());
            order.setFsnId(orderDTO.getFsnId());
            order.setGmv(orderDTO.getGmv());
            order.setModifiedDate(new Date());
            order.setOrderId(orderDTO.getOrderId());
            order.setOrderItemId(orderDTO.getOrderItemId());
            order.setOrderPaymentType(orderDTO.getOrderPaymentType());
            order.setProductMRP(orderDTO.getProductMRP());
            orderRepository.save(order);
            return true;
        }
        else{
            System.out.println("order not found to be updated");
            return false;
        }
    }

    public void deleteOrder(Long id){
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if(optionalOrder != null){
            orderRepository.deleteById(id);
        }
    }
}
