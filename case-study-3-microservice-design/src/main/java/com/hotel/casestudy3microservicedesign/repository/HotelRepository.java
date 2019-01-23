package com.hotel.casestudy3microservicedesign.repository;

import com.hotel.casestudy3microservicedesign.model.Hotel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long> {

    @Query(getAllHotelsByRank)
    List<Hotel> getAllPostsByRank(Pageable pageable);

    final String getAllHotelsByRank= "from Hotel order by id ASC";
}
