package com.hotel.casestudy3microservicedesign;

import com.hotel.casestudy3microservicedesign.model.Hotel;
import com.hotel.casestudy3microservicedesign.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class CaseStudy3MicroserviceDesignApplication implements CommandLineRunner {

	@Autowired
	HotelRepository hotelRepository;

	public static void main(String[] args) {
		SpringApplication.run(CaseStudy3MicroserviceDesignApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Hotel hotel = new Hotel();
		hotel.setName("Fortune Hotel");
		hotel.setCity("Gurgaon");
		hotel.setDescription("3 star hotel, located at awesome view");
		hotel.setRating(4);

		Hotel hotel2 = new Hotel();
		hotel2.setName("The Park");
		hotel2.setCity("Chennai");
		hotel2.setDescription("5 star hotel, taste of south");
		hotel2.setRating(5);

		Hotel hotel3 = new Hotel();
		hotel3.setName("Meluha The Fern");
		hotel3.setCity("Mumbai");
		hotel3.setDescription("No description available");
		hotel3.setRating(5);

		Hotel hotel4 = new Hotel();
		hotel4.setName("Taj Lands");
		hotel4.setCity("Chennai");
		hotel4.setDescription("Awesome hotel");
		hotel4.setRating(3);

		Hotel hotel5 = new Hotel();
		hotel5.setName("The Chancery Pavillion");
		hotel5.setCity("Bangluru");
		hotel5.setDescription("Not available");
		hotel5.setRating(5);

		Hotel hotel6 = new Hotel();
		hotel6.setName("Trident Gurgaon");
		hotel6.setCity("Gurgaon");
		hotel6.setDescription("Trident Gurgaon");
		hotel6.setRating(4);

		Hotel hotel7 = new Hotel();
		hotel7.setName("The Oberoi Bangalore");
		hotel7.setCity("Banglore");
		hotel7.setDescription("");
		hotel7.setRating(5);

		Hotel hotel8 = new Hotel();
		hotel8.setName("Manasarovar The Fern");
		hotel8.setCity("Hyderabad");
		hotel8.setDescription("");
		hotel8.setRating(5);

		Hotel hotel9 = new Hotel();
		hotel9.setName("Radisson Blu Hotel New Delhi Dwarka");
		hotel9.setCity("New Delhi");
		hotel9.setDescription("Awesome hotel");
		hotel9.setRating(5);

		Hotel hotel10 = new Hotel();
		hotel10.setName("The Lalit Great Eastern Kolkata");
		hotel10.setCity("Kolkata");
		hotel10.setDescription("Not available");
		hotel10.setRating(5);

		hotelRepository.save(hotel);
		hotelRepository.save(hotel2);
		hotelRepository.save(hotel3);
		hotelRepository.save(hotel4);
		hotelRepository.save(hotel5);
		hotelRepository.save(hotel6);
		hotelRepository.save(hotel7);
		hotelRepository.save(hotel8);
		hotelRepository.save(hotel9);
		hotelRepository.save(hotel10);
	}
}

