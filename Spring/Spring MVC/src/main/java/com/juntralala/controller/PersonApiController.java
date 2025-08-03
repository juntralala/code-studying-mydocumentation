package com.juntralala.controller;

import com.juntralala.model.CreatePersonRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
public class PersonApiController {

    @PostMapping(path = "/api/person", consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    @ResponseBody
    public CreatePersonRequest createPersonRequest(@RequestBody @Valid CreatePersonRequest personRequest) {
        return personRequest;
    }

}
