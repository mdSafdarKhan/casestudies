package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    /*@GetMapping("productId/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id){
        ProductDTO productDTO = productService.getProductById(id);
        if(productDTO != null){
            return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }*/

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createOrder(@RequestBody OrderDTO orderDTO){
        orderService.createOrder(orderDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /*@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateProduct(@RequestBody @Valid ProductDTO productDTO){
        productService.updateProduct(productDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteProduct(@RequestParam Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/
}
