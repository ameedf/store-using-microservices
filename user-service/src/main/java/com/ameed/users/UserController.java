package com.ameed.users;

import com.ameed.api.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RefreshScope
public class UserController {
    private int counter;
    private final UserRepository userRepository;
    private final String message;

    public UserController(UserRepository userRepository,
                          @Value("${custom.message}") String message) {
        this.userRepository = userRepository;
        this.message = message;
    }

    @PostMapping
    public User createUser(@RequestBody User newUser) {
        ++counter;
        return userRepository.save(newUser);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId) {
        ++counter;
        System.out.println(this.message);
        return userRepository.findById(userId).orElse(null);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
