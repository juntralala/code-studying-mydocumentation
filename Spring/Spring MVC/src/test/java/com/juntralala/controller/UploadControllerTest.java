package com.juntralala.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;
import java.io.IOException;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UploadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void uploadFile() throws IOException, Exception {
        mockMvc.perform(multipart("/upload/profile")
                .file(new MockMultipartFile("profile", "profile.png", "image/png",
                        getClass().getResourceAsStream("/images/profile.png")))
                .param("name", "Ujun")
                .contentType(MULTIPART_FORM_DATA)
        ).andExpectAll(
                status().isOk(),
                content().string("Success save profile Ujun to upload" + File.separator + "profile.png")
        );
    }


}
