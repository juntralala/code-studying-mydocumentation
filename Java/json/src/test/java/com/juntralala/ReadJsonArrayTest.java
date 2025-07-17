package com.juntralala;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ReadJsonArrayTest {

    @Test
    void readJsonArray() throws JsonProcessingException {
        String json = """
                ["Coding", "Gaming", "Sleep"]""";

        ObjectMapper mapper = new ObjectMapper();
        List<String> hobbies = mapper.readValue(json, new TypeReference<List<String>>() {});

        System.out.println(hobbies);
    }

}
