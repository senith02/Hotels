package com.example.Hotels.service;

import com.example.Hotels.data.Hotel;
import com.example.Hotels.data.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public List<Hotel> getHotels(){
        return hotelRepository.findAll();
    }

    public List<Hotel> getHotelByName(String hotelName){
        return hotelRepository.getHotelByName(hotelName);
    }

    public Hotel addHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }

    public boolean deleteHotel(String hotelId){
        if(hotelRepository.existsById(hotelId)){
            hotelRepository.deleteById(hotelId);
            return true;
        }
        else{
            return false;
        }
    }
}
