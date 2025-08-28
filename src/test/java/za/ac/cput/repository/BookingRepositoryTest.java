package za.ac.cput.repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Gig;
import za.ac.cput.factory.BookingFactory;
import za.ac.cput.factory.GigFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookingRepositoryTest {

    @Autowired
    private BookingRepository repository;

    @Autowired
    private GigRepository gigRepository;

    @Test
    void testSaveAndFindBooking() {

        Gig gig = GigFactory.build(null, 600, "Cape Town Club", "20:00-22:00", "Saturday", null);
        Gig savedGig = gigRepository.save(gig);

        Booking booking = BookingFactory.build(
                "Boitumelo",
                LocalDate.now(),
                LocalTime.of(20, 0),
                savedGig
        );

        Booking saved = repository.save(booking);
        assertNotNull(saved.getBookingId());

        Optional<Booking> found = repository.findById(saved.getBookingId());
        assertTrue(found.isPresent());
        assertEquals("Boitumelo", found.get().getCustomerName());

        repository.deleteById(saved.getBookingId());
        assertFalse(repository.findById(saved.getBookingId()).isPresent());
    }
}
