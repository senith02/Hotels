package com.example.Hotels.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AvailabilityRepository extends JpaRepository<RoomAvailability, String> {

    @Query("SELECT r FROM RoomAvailability r " +
            "WHERE r.roomId.roomId = ?1 " +
            "AND r.date BETWEEN ?2 AND ?3")
    List<RoomAvailability> findRoomAvailabilityByDate(String roomId, LocalDate startDate, LocalDate endDate);


    @Query(value = "SELECT r.room_id " +
            "FROM room_availability r " +
            "WHERE r.is_available = TRUE " +
            "  AND r.date BETWEEN ?1 AND ?2 " +
            "GROUP BY r.room_id " +
            "HAVING COUNT(r.date) = DATEDIFF(?2, ?1) + 1",
            nativeQuery = true)
    List<Room> findAvailableRoomsInDateRange(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}
