package com.example.Hotels.controller;

import com.example.Hotels.data.Room;
import com.example.Hotels.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class RoomController {

    @Autowired
    RoomService roomService;

    // Implement the following endpoints:
    // 1. GET /rooms
    @GetMapping(path = "/rooms")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping(path = "/rooms/{roomId}")
    public Room getRoomByRoomId(@PathVariable String roomId) {
        return roomService.getRoomByRoomId(roomId);
    }

    // 2. GET /hotels/{hotelId}/rooms
    @GetMapping(path = "/hotels/{hotelId}/rooms")
    public List<Room> getRoomsByHotelName(@PathVariable String hotelId) {
        return roomService.getRoomByHotelId(hotelId);
    }

    // 3. POST /rooms
    @PostMapping(path = "/rooms")
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    // 4. PUT /rooms
    @PutMapping(path = "/rooms")
    public Room updateRoom(@RequestBody Room room) {
        return roomService.updateRoom(room);
    }

    // 5. DELETE /rooms
    @DeleteMapping(path = "/rooms/{id}")
    public boolean deleteRoom(@PathVariable String id) {
        return roomService.deleteRoom(id);
    }

    // 6. GET /hotels/{hotelId}/availablerooms?checkIn={checkIn}&checkOut={checkOut}
    @GetMapping(path = "hotels/{hotelId}/availablerooms")
    public List<Room> getAvailableRoomsByHotelId(@PathVariable String hotelId,
                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut) {
        return roomService.getAvailableRoomsByHotelId(hotelId, checkIn, checkOut);
    }

//    // 7. GET /availablerooms?checkIn={checkIn}&checkOut={checkOut}
//    @GetMapping(path = "/availablerooms")
//    public List<Room> getAvailableRooms(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
//                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut ){
//        return roomService.getAvailableRooms(checkIn, checkOut);
//    }

}
