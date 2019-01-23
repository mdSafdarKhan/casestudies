package com.example.storeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreDTO {

    private Long storeId;
    private String storeName;
    private String email;
    private Long contactNumber;
    private Long pickupLocation;
    private String address;
    private Long gstinNumber;
}
