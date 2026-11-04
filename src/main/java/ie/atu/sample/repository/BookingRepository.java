package ie.atu.sample.repository;

import ie.atu.sample.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking getBookingById(Long id);
    @Query("""
SELECT b
fROM Booking b
JOIN b.room r
WHERE r.name = :roomName
ORDER BY b.attendeeCount
""")
    List<Booking> getBookingsByRoom_Name(@Param("roomName")String roomName);
}
