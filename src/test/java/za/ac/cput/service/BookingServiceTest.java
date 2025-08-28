package za.ac.cput.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Gig;
import za.ac.cput.factory.BookingFactory;
import za.ac.cput.factory.GigFactory;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookingServiceTest {

    @Autowired
    private BookingService bookingService;

    private Booking booking;

    @BeforeEach
    void setUp() {
        Gig gig = GigFactory.build(null, 500, "Rands CPT", "22:00-00:00", "Friday", null);
        booking = BookingFactory.build("Boitumelo", LocalDate.now(), LocalTime.of(22, 0), gig);
        bookingService.create(booking);
    }

    @Test
    void testCreateAndRead() {
        assertNotNull(booking.getBookingId());
        assertTrue(bookingService.read(booking.getBookingId()).isPresent());
    }

    @Test
    void testDelete() {
        bookingService.delete(booking.getBookingId());
        assertFalse(bookingService.read(booking.getBookingId()).isPresent());
    }
}


