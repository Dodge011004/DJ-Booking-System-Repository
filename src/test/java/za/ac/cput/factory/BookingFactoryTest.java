package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Gig;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class BookingFactoryTest {

    @Test
    void testBuild() {
        Gig gig = new Gig(1L, 500, "Rands CPT", "22:00 - 00:00", "Friday", null);
        Booking booking = BookingFactory.build("Boitumelo", LocalDate.now(), LocalTime.now(), gig);

        assertNotNull(booking);
        assertEquals("Boitumelo", booking.getCustomerName());
    }
}


