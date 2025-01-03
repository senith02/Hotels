package com.example.Hotels.service;


import org.springframework.web.client.RestTemplate;
import com.example.Hotels.data.Room;
import com.example.Hotels.data.RoomAvailability;
import com.example.Hotels.data.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    private RestTemplate restTemplate;

    //get all rooms
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    //get room by room id
    public Room getRoomByRoomId(String roomId) {
        return roomRepository.findById(roomId).orElse(null);
    }

    //get room by hotel id
    public List<Room> getRoomByHotelId(String hotelId) {
        return roomRepository.findRoomByHotelId(hotelId);
    }

    //add room
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    //update room
    public Room updateRoom(Room room) {
        return roomRepository.save(room);
    }

    //delete room
    public boolean deleteRoom(String roomId) {
        if(roomRepository.existsById(roomId)){
            roomRepository.deleteById(roomId);
            return true;
        }
        else{
            return false;
        }
    }

    //get available rooms
    public List<Room> getAvailableRoomsByHotelId(String hotelId, LocalDate checkIn, LocalDate checkOut) {
        // Fetch all rooms for the selected hotel
        List<Room> rooms = getRoomByHotelId(hotelId);

        // Extract room IDs
        List<String> roomIds = rooms.stream().map(Room::getRoomId).collect(Collectors.toList());

        // Call Booking Microservice to check room availability
        String url = String.format(
                "http://localhost:8081/booking/roomAvailability?roomIds=%s&startDate=%s&endDate=%s",
                String.join(",", roomIds), checkIn, checkOut
        );

        // Make the HTTP GET request
        ResponseEntity<RoomAvailability[]> response = restTemplate.getForEntity(url, RoomAvailability[].class);

        // Filter out rooms that are booked during the requested period
        List<String> unavailableRoomIds = Arrays.stream(response.getBody())
                .filter(roomAvailability -> checkIn != null && checkOut != null &&
                        checkIn.isBefore(roomAvailability.getEndDate()) && checkOut.isAfter(roomAvailability.getStartDate())
                )
                .map(RoomAvailability::getRoomId)
                .collect(Collectors.toList());

        return rooms.stream()
                .filter(room -> !unavailableRoomIds.contains(room.getRoomId()))
                .collect(Collectors.toList());
    }

    public List<Room> getAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
        //Fetch all rooms
        List<Room> rooms = getAllRooms();

        //Extract room IDs
        List<String> roomIds = rooms.stream().map(Room::getRoomId).collect(Collectors.toList());

        //Call Booking Microservice to check room availability
        String url = String.format(
                "http://localhost:8081/roomAvailability?roomIds=%s&startDate=%s&endDate=%s",
                String.join(",", roomIds), checkIn, checkOut
        );

        // Make the HTTP GET request
        ResponseEntity<RoomAvailability[]> response = restTemplate.getForEntity(url, RoomAvailability[].class);

        //Filter out rooms that are booked during the requested period
        List<String> unavailableRoomIds = Arrays.stream(response.getBody())
                .filter(roomAvailability ->
                        (checkIn.isBefore(roomAvailability.getEndDate()) && checkOut.isAfter(roomAvailability.getStartDate()))
                )
                .map(RoomAvailability::getRoomId)
                .collect(Collectors.toList());

        return rooms.stream()
                .filter(room -> unavailableRoomIds.contains(room.getRoomId()))
                .collect(Collectors.toList());
    }

}
