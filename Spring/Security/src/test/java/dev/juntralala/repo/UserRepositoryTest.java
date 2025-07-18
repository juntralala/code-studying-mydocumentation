package dev.juntralala.repo;

import dev.juntralala.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        var user = new User();
        user.setUsername("John");
        user.setPassword("rahasia");
        userRepository.save(user);
    }
}
