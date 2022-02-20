package com.haw.one4all;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnHomePage() throws Exception {
        // Verify controller responds with expected page
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Filter")));
    }

    @Test
    public void shouldReturnLoginPage() throws Exception {
        // Verify controller responds with expected page
        this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Anmelden")));
    }

    @Test
    public void shouldReturnRegistrationPage() throws Exception {
        // Verify controller responds with expected page
        this.mockMvc.perform(get("/register")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Registrierung")));
    }

    @Test
    public void shouldReturnImpressum() throws Exception {
        // Verify controller responds with expected page
        this.mockMvc.perform(get("/impressum")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Impressum")));
    }
}
