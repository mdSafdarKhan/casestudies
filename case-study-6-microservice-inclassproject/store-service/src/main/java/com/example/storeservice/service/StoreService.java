package com.example.storeservice.service;

import com.example.storeservice.dto.StoreDTO;
import com.example.storeservice.model.Store;
import com.example.storeservice.repository.StoreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StoreService {

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    ModelMapper modelMapper;

    /*public ProductDTO getProductById(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            System.out.println("found some product in service");
            Product product = optionalProduct.get();
            return modelMapper.map(product, ProductDTO.class);
        }
        else{
            System.out.println("product not found in service");
            return null;
        }
    }

    public ProductDTO getProductByName(String name){
        Optional<Product> optionalProduct = productRepository.findByName(name);
        if(optionalProduct.isPresent()){
            System.out.println("found product");
            return modelMapper.map(optionalProduct.get(), ProductDTO.class);
        }
        else{
            System.out.println("product not found");
            return null;
        }
    }

    public List<ProductDTO> getProductByCategory(String category, int page, int limit){
        List<ProductDTO> productDTOS = new ArrayList<>();
        List<Product> products = productRepository.findByCategory(category, new PageRequest(page, limit, Sort.Direction.ASC, "name"));

        if(products != null){
            System.out.println("found products by category");
            for(Product product : products){
                productDTOS.add(modelMapper.map(product, ProductDTO.class));
            }
            return productDTOS;
        }
        else{
            System.out.println("products by category not found");
            return null;
        }
    }

    public List<ProductDTO> getProductByBrand(String brand, int page, int limit){
        List<ProductDTO> productDTOS = new ArrayList<>();
        List<Product> products = productRepository.findByBrand(brand, new PageRequest(page, limit, Sort.Direction.ASC, "name"));
        for(Product product : products){
            productDTOS.add(modelMapper.map(product, ProductDTO.class));
        }
        return productDTOS;
    }*/

    public void createStore(StoreDTO storeDTO){
        Store store = Store.builder()
                .storeName(storeDTO.getStoreName())
                .address(storeDTO.getAddress())
                .contactNumber(storeDTO.getContactNumber())
                .createDate(new Date())
                .email(storeDTO.getEmail())
                .modifiedDate(new Date())
                .gstinNumber(storeDTO.getGstinNumber())
                .pickupLocation(storeDTO.getPickupLocation())
                .build();
        storeRepository.save(store);
    }

    /*public boolean updateProduct(ProductDTO productDTO){
        Optional<Product> savedProduct = productRepository.findById(productDTO.getId());
        if(savedProduct != null){
            System.out.println("found product to be updated");
            Product product = savedProduct.get();
            product.setName(productDTO.getName());
            product.setBrand(productDTO.getBrand());
            product.setCategory(productDTO.getCategory());
            product.setColor(productDTO.getColor());
            product.setModifiedDate(new Date());
            product.setDescription(productDTO.getDescription());
            productRepository.save(product);
            return true;
        }
        else{
            System.out.println("product not found to be updated");
            return false;
        }
    }

    public void deleteProduct(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct != null){
            productRepository.deleteById(id);
        }
    }*/
}
