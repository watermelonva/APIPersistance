package com.easylink.api.persist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.easylink.api.model.Hotel;
import com.easylink.api.service.HotelService;

@SpringBootApplication
public class Application {
	
//	@Autowired
//	HotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	
//	@Override
//	public void run(String... arg0) throws Exception {
//		
//		List<Hotel> hotels = hotelService.findAll();
//		for(Hotel hotel : hotels)
//		{
//			System.out.println("Hotel Name => " + hotel.getName());
//		}
//	}
}