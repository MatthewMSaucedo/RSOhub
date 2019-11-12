package com.RSOhub.hub.api;

import com.RSOhub.hub.dao.UserRepository;
import com.RSOhub.hub.dto.LoginOrRegisterRequest;
import com.RSOhub.hub.model.User;
import com.RSOhub.hub.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("api/auth")
@RestController
public class AuthController {
    private final UserRepository userRepository;

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "login")
    public User login(@RequestBody LoginOrRegisterRequest loginRequest) {
        try {
            return userRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping(path = "register")
    public User register(@RequestBody LoginOrRegisterRequest registerRequest) {
        try {
            User newUser = new User(registerRequest.getUsername(), registerRequest.getPassword(), UserType.STANDARD);
            return userRepository.save(newUser);
        } catch (Exception e) {
            return null;
        }
    }
}
