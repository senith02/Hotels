package com.example.Hotels.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {

    @Query("select r from Room r where r.hotel.hotelId =?1")
    public List<Room> findRoomByHotelId(String hotelId);

    @Query("select r from Room r where r.roomId =?1")
    public Room findRoomById(String roomId);



}
