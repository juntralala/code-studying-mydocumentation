package dev.juntralala.controller;

import dev.juntralala.model.User;
import dev.juntralala.service.UserService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserController {

    private UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        log.info("Hello");
        return this.service.register(user);
    }

    @RequestMapping("/login")
    public String login(@RequestBody User user) {
        return this.service.verify(user);
    }
}
