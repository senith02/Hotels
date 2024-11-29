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

    // Implement the following endpoints:
    // 1. GET /hotels
    @GetMapping(path = "/hotels")
    public List<Hotel> getAllHotels() {
        return hotelService.getHotels();
    }

    // 2. GET /hotels?name={name}
    @GetMapping(path = "/hotels",params = "name")
    public List<Hotel> getHotelsByName(@RequestParam String name) {
        return hotelService.getHotelByName(name);
    }

    // 3. POST /hotels
    @PostMapping(path = "/hotels")
    public Hotel createHotels(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }

    // 4. PUT /hotels
    @PutMapping(path = "/hotels")
    public Hotel updateHotel(@RequestBody Hotel hotel) {
        return hotelService.updateHotel(hotel);
    }

    // 5. DELETE /hotels
    @DeleteMapping(path = "/hotels")
    public boolean deleteHotel(@RequestParam String id) {
        return hotelService.deleteHotel(id);
    }
}
