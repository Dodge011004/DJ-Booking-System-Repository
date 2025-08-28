package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Gig;
import za.ac.cput.domain.DJ;

import static org.junit.jupiter.api.Assertions.*;

class GigFactoryTest {

    @Test
    void testBuild() {
        DJ dj = new DJ(1L, "DJ Max", "0821234567", "djmax@example.com", "Resident");
        Gig gig = GigFactory.build(1L, 500, "Rands CPT", "22:00 - 00:00", "Friday", dj);

        assertNotNull(gig);
        assertEquals("Rands CPT", gig.getGigVenue());
    }
}




    


