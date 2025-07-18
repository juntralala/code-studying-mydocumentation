package com.juntralala.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juntralala.model.HelloRequest;
import com.juntralala.model.HelloResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
public class BodyController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(path = "/hello/body", consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    @ResponseBody
    public String json(@RequestBody String body) throws JsonProcessingException {
        HelloRequest helloRequest = objectMapper.readValue(body, HelloRequest.class);

        HelloResponse helloResponse = new HelloResponse();
        helloResponse.setHello("Hello " + helloRequest.getName());

        return objectMapper.writeValueAsString(helloResponse);
    }

}
