package com.juntralala.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HeaderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void header() throws Exception {
        mockMvc.perform(
                get("/header/token").header("X-Token", "OZON")
        ).andExpectAll(
                status().isOk(),
                content().string("OZON")
        );
    }

    @Test
    void headerInvalidXToken() throws Exception {
        mockMvc.perform(
                get("/header/token").header("X-Token", "Salah")
        ).andExpectAll(
                status().isOk(),
                content().string("Invalid-Token")
        );
    }

}
