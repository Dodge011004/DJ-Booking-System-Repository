package za.ac.cput.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Gig;
import za.ac.cput.factory.GigFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GigServiceTest {

    @Autowired
    private GigService gigService;

    private Gig gig;

    @BeforeEach
    void setUp() {
        gig = GigFactory.build(null, 600, "Cape Town Club", "20:00-22:00", "Saturday", null);
        gigService.create(gig);
    }

    @Test
    void testCreateAndRead() {
        assertNotNull(gig.getGigId());
        assertTrue(gigService.read(gig.getGigId()).isPresent());
    }

    @Test
    void testDelete() {
        gigService.delete(gig.getGigId());
        assertFalse(gigService.read(gig.getGigId()).isPresent());
    }
}

