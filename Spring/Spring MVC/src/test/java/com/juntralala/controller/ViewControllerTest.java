package com.juntralala.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ViewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloView() throws Exception {
        mockMvc.perform(
        get("/web/hello")
                .queryParam("name", "ujun")
        ).andExpectAll(
                status().isOk(),
                content().string(containsString("Belajar View")),
                content().string(containsString("Hello ujun"))
        );
    }

    @Test
    void helloViewRedirect() throws Exception {
        mockMvc.perform(
        get("/web/hello")
        ).andExpectAll(
                status().is3xxRedirection()
        );
    }

}
