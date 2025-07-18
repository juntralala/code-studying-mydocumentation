package com.juntralala.controller;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.RequestResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    void addTodo() throws Exception {
        mockMvc.perform(
                post("/todos")
                        .queryParam("todo", "Coding")
        ).andExpectAll(
                status().isOk(),
                content().string(containsString("Coding"))
        );
    }

    @Test
    @Order(2)
    void getTodo() throws Exception {
        mockMvc.perform(
                get("/todos")
        ).andExpectAll(
                status().isOk(),
                content().string(containsString("Coding"))
        );
    }

}
