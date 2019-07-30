package com.easylink.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easylink.api.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

	
}



