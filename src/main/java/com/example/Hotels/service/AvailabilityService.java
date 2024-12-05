package com.example.Hotels.service;

import com.example.Hotels.data.AvailabilityRepository;
import com.example.Hotels.data.Room;
import com.example.Hotels.data.RoomAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AvailabilityService {

    @Autowired
    AvailabilityRepository roomAvailable;

    public List<Room> getAllRoomAvailability(LocalDate StartDate, LocalDate EndDate) {
        return roomAvailable.findAvailableRoomsInDateRange(StartDate, EndDate);
    }

    public List<RoomAvailability> findRoomAvailabilityByDate(String roomId, LocalDate StartDate, LocalDate EndDate) {
        return roomAvailable.findRoomAvailabilityByDate(roomId, StartDate, EndDate);
    }
}
