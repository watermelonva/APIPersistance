package com.easylink.api.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easylink.api.model.Hotel;
import com.easylink.api.repository.HotelRepository;



@Service
@Transactional
public class HotelService {
    @Autowired
    private HotelRepository repository;

    public Hotel save(Hotel hotel) {

        return repository.saveAndFlush(hotel);
    }
    
    public List<Hotel> findAll() {

        return repository.findAll();
    }
    
    
    
}
