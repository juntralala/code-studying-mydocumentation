package com.juntralala.controller;

import com.juntralala.model.CreatePersonRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

@Controller
@ResponseBody
public class PersonController {

    @PostMapping(path = {"/person"}, consumes = APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> createPerson(@ModelAttribute @Valid CreatePersonRequest request, BindingResult bindingResult) {

//        List<ObjectError> errors = bindingResult.getAllErrors();
        List<FieldError> errors = bindingResult.getFieldErrors();
        if (!errors.isEmpty()) {
//            errors.forEach(objectError -> {
//                System.out.println(objectError.getDefaultMessage());
//            });

            errors.forEach(fieldError -> {
                System.out.println(fieldError.getField() + ": " + fieldError.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body("You send invalid data");
        }

        System.out.println(request);
        String response = new StringBuilder().append("Success create person ")
                .append(request.getFirstName()).append(" ")
                .append(request.getMiddleName()).append(" ")
                .append(request.getLastName()).append(" ")
                .append("with email ").append(request.getEmail()).append(" ")
                .append("and with phone ").append(request.getPhone()).append(" ")
                .append("with address ").append(request.getAddress().getStreet()).append(", ")
                .append(request.getAddress().getCity()).append(", ")
                .append(request.getAddress().getCountry()).append(", ")
                .append(request.getAddress().getPostalCode())
                .toString();
        return ResponseEntity.ok(response);
    }

}
