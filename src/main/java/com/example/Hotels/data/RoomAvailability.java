package com.example.Hotels.data;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.UUID;

@Entity
@Table(name = "room_availability")
public class RoomAvailability {

    @Id
    @Column(name = "availability_id", nullable = false, updatable = false)
    private String roomAvailabilityId;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room roomId;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "is_available", nullable = false)
    private Boolean availability;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private String createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private String updatedAt;

    public RoomAvailability() {
        roomAvailabilityId = UUID.randomUUID().toString();
    }

    public String getRoomAvailabilityId() {
        return roomAvailabilityId;
    }

    public void setRoomAvailabilityId(String roomAvailabilityId) {
        this.roomAvailabilityId = roomAvailabilityId;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
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
