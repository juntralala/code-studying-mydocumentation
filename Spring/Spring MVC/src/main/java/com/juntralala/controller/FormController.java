package com.juntralala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formattable;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.TEXT_HTML_VALUE;

@Controller
public class FormController {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @PostMapping(path = "/form/hello",
            consumes = {APPLICATION_FORM_URLENCODED_VALUE},
            produces = {TEXT_HTML_VALUE})
    @ResponseBody
    public String hello(@RequestParam(name = "name") String name) {
        return """
                <!DOCTYPE html>
                <html>
                    <body>
                        <h1>Hello $name</h1>
                    </body>
                </html>""".replace("$name", name);
    }

    @PostMapping(path = "/form/person", consumes = APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String createPerson(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "birthDate") Date birthDate,
            @RequestParam(name = "address") String address
    ) {
        return "Success create Person with name : " + name +
                ", birthDate : " + dateFormat.format(birthDate) +
                ", address : " + address;
    }

}
