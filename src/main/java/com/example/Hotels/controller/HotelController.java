package com.example.Hotels.controller;

import com.example.Hotels.data.Hotel;
import com.example.Hotels.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping(path = "/hotels")
    public List<Hotel> getAllHotels() {
        return hotelService.getHotels();
    }

    @GetMapping(path = "/hotels",params = "name")
    public List<Hotel> getHotelsByName(@RequestParam String name) {
        return hotelService.getHotelByName(name);
    }

    @PostMapping(path = "/hotels")
    public Hotel createHotels(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }
}
