package com.juntralala;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class WriteJsonTest {

    public Map getData () {
        return Map.of(
                "firstName", "Muhammad",
                "lastName", "Junaidi",
                "age", 30,
                "married", true,
                "address", (Map.of(
                        "street", "Tanah Besi",
                        "city", "Tambang Intan",
                        "country", "Imagian"
                ))
        );
    }

    @Test
    void createJson() throws JsonProcessingException {
        Map data = this.getData();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(data);
        System.out.println(json);
    }

    @Test
    void createJsonToFileWithOutputStream() throws IOException {
        Map data = this.getData();

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(Files.newOutputStream(Path.of("output.json")), data);
    }

    @Test
    void createJsonToFileWithWriter() throws IOException {
        Map data = this.getData();

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(Files.newBufferedWriter(Path.of("writed.json")), data);
    }

    @Test
    void createJsonToFileWithFileClass() throws IOException {
        Map data = this.getData();

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("data-file.json"), data);
    }
}
