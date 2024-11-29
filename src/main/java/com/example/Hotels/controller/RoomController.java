package com.example.Hotels.controller;

import com.example.Hotels.data.Room;
import com.example.Hotels.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping(path = "/rooms")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }
}
