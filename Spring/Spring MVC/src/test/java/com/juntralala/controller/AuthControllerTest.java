package com.juntralala.controller;

import jakarta.servlet.http.Cookie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void loginSuccess() throws Exception {
        mockMvc.perform(
                post("/auth/login")
                        .contentType(APPLICATION_FORM_URLENCODED)
                        .param("username", "ujun")
                        .param("password", "rahasia")
        ).andExpectAll(
                status().isOk(),
                content().string("OK"),
                cookie().value("username", "ujun")
        ).andDo(result -> {
            for (Cookie cookie : result.getResponse().getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue() + " " + cookie.getAttributes());
            }
        });
    }

    @Test
    void loginFailed() throws Exception {
        mockMvc.perform(
                post("/auth/login")
                        .contentType(APPLICATION_FORM_URLENCODED)
                        .param("username", "ujun")
                        .param("password", "salah")
        ).andExpectAll(
                status().isUnauthorized(),
                content().string("KO")
        );
    }

    @Test
    void getUser() throws Exception {
        mockMvc.perform(
                get("/auth/user")
                        .cookie(new Cookie("username", "ujun"))
        ).andExpectAll(
                status().isOk(),
                content().string("Hello ujun")
        );
    }
}
