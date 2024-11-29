package com.example.Hotels.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {

    @Query("select h from Hotel h where h.hotelName=?1")
    public List<Hotel> getHotelByName(String name);

}
