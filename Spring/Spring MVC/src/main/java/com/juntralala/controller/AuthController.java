package com.juntralala.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

@Controller
public class AuthController {

    @PostMapping(path = "/auth/login", consumes = {APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<String> login(@RequestParam(name = "username") String username,
                                        @RequestParam(name = "password") String password,
                                        HttpServletResponse response) {
        if (username.equals("ujun") && password.equals("rahasia")) {
            Cookie cookie = new Cookie("username", username);
            cookie.setPath("/");
            cookie.setMaxAge((int) ChronoUnit.SECONDS.between(LocalDateTime.now(), LocalDateTime.now().plusDays(7)));
            response.addCookie(cookie);
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("KO", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(path = "/auth/user")
    public ResponseEntity<String> getUser(@CookieValue(name = "username") String username) {
        return ResponseEntity.ok("Hello " + username);
    }
}
