package com.hotel.casestudy3microservicedesign.controller;

import com.hotel.casestudy3microservicedesign.model.Hotel;
import com.hotel.casestudy3microservicedesign.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelRepository hotelRepository;

    @GetMapping
    public Iterable<Hotel> getHotel(@RequestParam("page") Integer page, @RequestParam("size") Integer size){
        //return hotelRepository.findAll();
        return hotelRepository.getAllPostsByRank(new PageRequest(page, size));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateHotel(@RequestBody Hotel hotel, @PathVariable Long id){
        System.out.println("Inside");
        Optional<Hotel> optional = hotelRepository.findById(id);

        if(!optional.isPresent()){
            return ResponseEntity.notFound().build();
        }

        Hotel h = optional.get();
        h.setName(hotel.getName());
        h.setCity(hotel.getCity());
        h.setDescription(hotel.getDescription());
        h.setRating(hotel.getRating());
        h= hotelRepository.save(h);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
