package ie.atu.sample.service;

import ie.atu.sample.dto.BookingInput;
import ie.atu.sample.dto.BookingResponse;
import ie.atu.sample.model.Booking;
import ie.atu.sample.model.Room;
import ie.atu.sample.repository.BookingRepository;
import ie.atu.sample.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;

    public BookingService(RoomRepository roomRepository, BookingRepository bookingRepository) {
        this.roomRepository = roomRepository;
        this.bookingRepository = bookingRepository;
    }

    public BookingInput createBooking(BookingInput bookingInput) {
        Booking booking = new Booking();

        Room room = roomRepository.getRoomById((bookingInput.getRoomId()));

        booking.setRoom(room);
        booking.setOrganiserName(bookingInput.getOrganiserName());
        if(room.getCapacity()<bookingInput.getAttendeeCount())
        {
            throw new IllegalArgumentException("Room Capacity Exceeded");
        }
        booking.setAttendeeCount(bookingInput.getAttendeeCount());
        bookingRepository.save(booking);
        return bookingInput;
    }

    public BookingResponse readBooking(Long id) {
        BookingResponse bookingResponse = new BookingResponse();
        Booking booking = new Booking();

        booking = bookingRepository.getBookingById(id);
        bookingResponse.setId(booking.getId());
        bookingResponse.setRoomId(booking.getRoom().getId());
        bookingResponse.setRoomName(booking.getRoom().getName());
        bookingResponse.setOrganiserName(booking.getOrganiserName());
        bookingResponse.setAttendeeCount(booking.getAttendeeCount());
        bookingResponse.setStatus("ACTIVE");
        return bookingResponse;
    }

    public List<Booking> getBookingByRoomName(String roomname) {
        return bookingRepository.getBookingsByRoom_Name(roomname);
    }
}
