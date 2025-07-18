package com.juntralala.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void date() throws Exception {
        mockMvc.perform(
                get("/date").queryParam("date", "2025-02-13")
        ).andExpectAll(
                status().isOk(),
                content().string(containsString("Date: 20250213"))
        );
    }

}
