package com.juntralala;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WriteJsonArrayTest {

    @Test
    void createJsonArray() throws JsonProcessingException {
        List<String> hobbies = List.of("Coding", "Reading", "Traveling");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(hobbies);

        System.out.println(json);
    }

}
