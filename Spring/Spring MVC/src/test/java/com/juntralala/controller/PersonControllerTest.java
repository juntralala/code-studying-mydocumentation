package com.juntralala.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createPerson() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName", "Kapten")
                        .param("middleName", "ujun")
                        .param("lastName", "tak")
                        .param("phone", "081234567")
                        .param("email", "ujun@email.com")
                        .param("address.street", "aspal")
                        .param("address.city", "jakarta")
                        .param("address.country", "Indonesia")
                        .param("address.postalCode", "112233")
                        .param("hobbies[0]", "Coding")
                        .param("hobbies[1]", "Gaming")
                        .param("hobbies[2]", "Scrolling Facebook")
                        .param("socialMedias[0].name", "Facebook")
                        .param("socialMedias[0].location", "https://facebook.com/ujun")
                        .param("socialMedias[1].name", "Instagram")
                        .param("socialMedias[1].location", "https://instagram.com/ujun")
        ).andExpectAll(
                status().isOk(),
                content().string("Success create person Kapten ujun tak with email ujun@email.com and with phone 081234567 " +
                        "with address aspal, jakarta, Indonesia, 112233")
        );
    }

    @Test
    @DisplayName("Create Person Failed, send not complete data (no fist name and email)")
    void createPersonFailed() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName", "")
                        .param("middleName", "ujun")
                        .param("lastName", "tak")
                        .param("phone", "081234567")
                        .param("email", "")
                        .param("address.street", "aspal")
                        .param("address.city", "jakarta")
                        .param("address.country", "Indonesia")
                        .param("address.postalCode", "112233")
                        .param("hobbies[0]", "Coding")
                        .param("hobbies[1]", "Gaming")
                        .param("hobbies[2]", "Scrolling Facebook")
                        .param("socialMedias[0].name", "Facebook")
                        .param("socialMedias[0].location", "https://facebook.com/ujun")
                        .param("socialMedias[1].name", "Instagram")
                        .param("socialMedias[1].location", "https://instagram.com/ujun")
        ).andExpectAll(
                status().isBadRequest(),
                content().string(containsString("You send invalid data"))
        );
    }

}
