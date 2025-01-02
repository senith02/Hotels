package com.example.Hotels.data;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.UUID;

@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @Column(name = "hotel_id", nullable = false, updatable = false, columnDefinition = "char(36)")
    private String hotelId;

    @Column(name = "name", nullable = false)
    private String hotelName;

    @Column(name = "location", nullable = false)
    private String hotelAddress;

    @Column(name = "description", columnDefinition = "text")
    private String hotelDescription;

    @Lob
    @Column(name = "amenities", columnDefinition = "json")
    private String amenities; // Or use List<String> with a custom converter

    @Column(name = "rating", columnDefinition = "float")
    private double rating;

    @Column(name = "created_at", updatable = false, columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP")
    @CreationTimestamp
    private String createdAt;

    @Column(name = "updated_at", columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @UpdateTimestamp
    private String updatedAt;

    @Column(name = "price_per_night", columnDefinition = "decimal(10,2)")
    private Double pricePerNight; // Changed to Double

    @Column(name = "subtitle", columnDefinition = "varchar(255)")
    private String subtitle;

    // Constructors
    public Hotel() {
        this.hotelId = UUID.randomUUID().toString();
    }

    // Getters and Setters
    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
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

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}