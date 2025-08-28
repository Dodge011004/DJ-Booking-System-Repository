package za.ac.cput.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.ac.cput.domain.Gig;
import za.ac.cput.factory.GigFactory;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class GigControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreateGig() throws Exception {
        Gig gig = GigFactory.build(null, 600, "Cape Town Club", "20:00-22:00", "Saturday", null);

        mockMvc.perform(post("/api/gigs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(gig)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.gigVenue").value("Cape Town Club"));
    }
}

