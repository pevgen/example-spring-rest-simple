package ml.pevgen.example.springrestsimple.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@ActiveProfiles({"test"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get(BookResource.RESOURCE_URI_BOOKS))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.pageable").isNotEmpty());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get(BookResource.RESOURCE_URI_BOOKS + "/123"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void testPage() throws Exception {
        mockMvc.perform(get(BookResource.RESOURCE_URI_BOOKS + "/test"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("test")));
    }
}