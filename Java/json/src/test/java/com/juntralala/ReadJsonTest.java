package com.juntralala;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class ReadJsonTest {

    @Test
    void readJsonFromString() throws JsonProcessingException {
        String json = """
                {
                  "age" : 30,
                  "married" : true,
                  "lastName" : "Junaidi",
                  "firstName" : "Muhammad",
                  "address" : {
                    "country" : "Imagian",
                    "city" : "Tambang Intan",
                    "street" : "Tanah Besi"
                  }
                }""";

        ObjectMapper mapper = new ObjectMapper();
//        Map<String, Object> orang = mapper.readValue(json, Map.class);
        // atau
        Map<String, Object> orang = mapper.readValue(json, new TypeReference<Map<String, Object>>() {});

        orang.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    @Test
    void readJsonWithInputStream() throws IOException {
        InputStream stream = Files.newInputStream(Path.of("person.json"));
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> orang = mapper.readValue(stream, new TypeReference<Map<String, Object>>() {});

        orang.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    @Test
    void readJsonWithReader() throws IOException {
        Reader reader = Files.newBufferedReader(Path.of("person.json"));
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> orang = mapper.readValue(reader, new TypeReference<Map<String, Object>>() {});

        orang.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    @Test
    void readJsonWithFileClass() throws IOException {
        File file = new File("data-file.json");
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> orang = mapper.readValue(file, new TypeReference<Map<String, Object>>() {});

        orang.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    @Test
    void readJsonWithStringOfPath() throws IOException {
        byte[] bytes = """
                {"age":30,"married":true,"lastName":"Junaidi","firstName":"Muhammad","address":{"country":"Imagian","city":"Tambang Intan","street":"Tanah Besi"}}
                """.getBytes();
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> orang = mapper.readValue(bytes, Map.class);

        orang.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
