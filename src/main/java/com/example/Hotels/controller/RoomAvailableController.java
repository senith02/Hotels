package com.example.Hotels.controller;

import com.example.Hotels.data.AvailabilityRepository;
import com.example.Hotels.data.Room;
import com.example.Hotels.data.RoomAvailability;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class RoomAvailableController {

    AvailabilityRepository roomAvailable;

    // Implement the following endpoints:
    @GetMapping(path = "/rooms/{roomId}/availability",params = {"roomId","StartDate", "EndDate"})
    public List<RoomAvailability> findRoomAvailabilityByDate(
            @RequestParam String roomId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate StartDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate EndDate) {
        return roomAvailable.findRoomAvailabilityByDate(roomId, StartDate, EndDate);
    }

    @GetMapping(path = "/availability", params = {"startDate", "endDate"})
    public List<Room> getAllRoomAvailability(
            @RequestParam(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return roomAvailable.findAvailableRoomsInDateRange(startDate, endDate);
    }
}
