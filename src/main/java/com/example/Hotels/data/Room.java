package com.example.Hotels.data;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.UUID;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @Column(name = "room_id", nullable = false, updatable = false)
    private String roomId;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false) // Foreign key linking to the hotels table
    private Hotel hotel;

    @Column(name = "room_type", nullable = false)
    private String roomType;

    @Column(name = "price_per_night", nullable = false)
    private double pricePerNight;

//    @Column(name = "availability", nullable = false)
//    private Boolean availability;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private String createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private String updatedAt;


    public Room() {
        roomId = UUID.randomUUID().toString();
    }

    public String getRoomId() {
        return roomId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

//    public Boolean getAvailability() {
//        return availability;
//    }
//
//    public void setAvailability(Boolean availability) {
//        this.availability = availability;
//    }

    public Double getPrice_per_night() {
        return pricePerNight;
    }

    public void setPrice_per_night(Double price_per_night) {
        this.pricePerNight = price_per_night;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
