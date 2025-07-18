package dev.juntralala;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.service.annotation.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        RestClient client = RestClient.create();
        SpringApplication.run(Main.class, args);
    }

//    @Autowired
//    public void p(AuthenticationEventPublisher authenticationEventPublisher) {
//        System.out.println("Thisis not alogging: " + authenticationEventPublisher.getClass().getName());
//    }

//    @Autowired
//    public void insertFirstUser(JdbcUserDetailsManager userDetailsManager, PasswordEncoder passwordEncoder) {
//        UserDetails user = User.builder()
//                .username("jun")
//                .password("rahasia")
//                .passwordEncoder(passwordEncoder::encode)
//                .authorities("User")
//                .build();
//        userDetailsManager.createUser(user);
//    }
}