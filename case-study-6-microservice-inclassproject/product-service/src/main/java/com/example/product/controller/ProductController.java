package com.example.product.controller;

import com.example.product.dto.ProductDTO;
import com.example.product.model.Product;
import com.example.product.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/product")
public class ProductController {

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	
    @Autowired
    ProductService productService;

    @GetMapping("productId/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id){
    	log.info("inside getProductById");
        ProductDTO productDTO = productService.getProductById(id);
        if(productDTO != null){
            return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("productName/{name}")
    public ResponseEntity<ProductDTO> getProductByName(@PathVariable("name") String name){
        ProductDTO productDTO = productService.getProductByName(name);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @GetMapping("productCategory")
    public ResponseEntity<List<ProductDTO>> getProductByCategory(@RequestParam("category") String category,
                                                                 @RequestParam("page") Integer page,
                                                                 @RequestParam("limit") Integer limit){
        List<ProductDTO> productDTOs = productService.getProductByCategory(category, page, limit);
        return new ResponseEntity<>(productDTOs, HttpStatus.OK);
    }

    @GetMapping("productBrand")
    public ResponseEntity<List<ProductDTO>> getProductByBrand(@RequestParam("brand") String brand,
                                                              @RequestParam("page") Integer page,
                                                              @RequestParam("limit") Integer limit){
        List<ProductDTO> productDTOS = productService.getProductByBrand(brand, page, limit);
        return new ResponseEntity<>(productDTOS, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addProduct(@RequestBody @Valid ProductDTO productDTO){
        productService.addProduct(productDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateProduct(@RequestBody @Valid ProductDTO productDTO){
        productService.updateProduct(productDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteProduct(@RequestParam Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
