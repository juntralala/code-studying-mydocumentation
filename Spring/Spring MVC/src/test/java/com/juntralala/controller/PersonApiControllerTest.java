package com.juntralala.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juntralala.model.CreateAddressRequest;
import com.juntralala.model.CreatePersonRequest;
import com.juntralala.model.CreateSocialMediaRequest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createPerson() throws Exception {
        var address = new CreateAddressRequest("Padi Madiri", "Martasari", "Indonesia", "112233");
        List<String> hobbies = List.of("Coding", "Gaming", "Sleeping");
        List<CreateSocialMediaRequest> socialMedias = List.of(
                new CreateSocialMediaRequest("Facebook", "https://facebook.com/ujun"),
                new CreateSocialMediaRequest("Instagram", "https://instagram.com/ujun")
        );
        var request = new CreatePersonRequest(
                "Kapten",
                "Ozon",
                "Luar Biasa",
                "ozon@gmail.com",
                "08123456789",
                address,
                hobbies,
                socialMedias);
        var jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                post("/api/person")
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON)
                        .content(jsonRequest)
        ).andExpectAll(
                status().isOk(),
                content().string(jsonRequest)
        );
    }

    @Test
    @DisplayName("Create Person Failed, send not complete data (no fist name and email)")
    void createPersonFailed() throws Exception {
        var address = new CreateAddressRequest("Padi Mandiri", "Martasari", "Indonesia", "112233");
        List<String> hobbies = List.of("Coding", "Gaming", "Sleeping");
        List<CreateSocialMediaRequest> socialMedias = List.of(
                new CreateSocialMediaRequest("Facebook", "https://facebook.com/ujun"),
                new CreateSocialMediaRequest("Instagram", "https://instagram.com/ujun")
        );
        var request = new CreatePersonRequest(
                "",
                "Ozon",
                "Luar Biasa",
                "",
                "08123456789",
                address,
                hobbies,
                socialMedias);
        var jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                post("/api/person")
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON)
                        .content(jsonRequest)
        ).andExpectAll(
                status().isBadRequest(),
                content().string(containsString("Validation Error"))
        ).andDo(result -> {
            System.out.println("Content: " + result.getResponse().getContentAsString());
        });
    }


}
