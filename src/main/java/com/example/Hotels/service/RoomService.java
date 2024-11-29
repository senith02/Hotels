package com.example.Hotels.service;

import com.example.Hotels.data.Room;
import com.example.Hotels.data.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public List<Room> getRoomByHotelId(String hotelId) {
        return roomRepository.findRoomByHotelId(hotelId);
    }

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Room room) {
        return roomRepository.save(room);
    }

    public boolean deleteRoom(String roomId) {
        if(roomRepository.existsById(roomId)){
            roomRepository.deleteById(roomId);
            return true;
        }
        else{
            return false;
        }
    }
}
