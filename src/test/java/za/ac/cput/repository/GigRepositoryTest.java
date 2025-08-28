package za.ac.cput.repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import za.ac.cput.domain.DJ;
import za.ac.cput.domain.Gig;
import za.ac.cput.factory.GigFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class GigRepositoryTest {

    @Autowired
    private GigRepository gigRepository;

    @Test
    void testSaveAndFindById() {
        DJ dj = new DJ(1L, "DJ Tumi", "House"); // adjust to your actual DJ constructor
        Gig gig = GigFactory.build(1L, 1500.0, "Cape Town Club", "22:00-02:00", "Friday", dj);

        Gig savedGig = gigRepository.save(gig);

        assertNotNull(savedGig);
        assertEquals("Cape Town Club", savedGig.getVenue());

        Optional<Gig> foundGig = gigRepository.findById(savedGig.getGigId());
        assertTrue(foundGig.isPresent());
        assertEquals("Friday", foundGig.get().getDayOfWeek());
    }

    @Test
    void testFindAll() {
        DJ dj = new DJ(2L, "DJ Black", "HipHop");
        Gig gig1 = GigFactory.build(2L, 1000.0, "Durban Spot", "20:00-23:00", "Saturday", dj);
        Gig gig2 = GigFactory.build(3L, 2000.0, "Jozi Bar", "23:00-03:00", "Sunday", dj);

        gigRepository.save(gig1);
        gigRepository.save(gig2);

        List<Gig> gigs = gigRepository.findAll();
        assertEquals(2, gigs.size());
    }

    @Test
    void testDeleteById() {
        DJ dj = new DJ(3L, "DJ Fresh", "Dance");
        Gig gig = GigFactory.build(4L, 1800.0, "Pretoria Lounge", "21:00-01:00", "Thursday", dj);

        Gig savedGig = gigRepository.save(gig);
        Long gigId = savedGig.getGigId();

        gigRepository.deleteById(gigId);

        Optional<Gig> deletedGig = gigRepository.findById(gigId);
        assertFalse(deletedGig.isPresent());
    }
}
