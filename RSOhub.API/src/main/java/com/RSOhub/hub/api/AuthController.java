package com.RSOhub.hub.api;

import com.RSOhub.hub.dao.UserRepository;
import com.RSOhub.hub.dto.LoginOrRegisterRequest;
import com.RSOhub.hub.dto.LoginResponse;
import com.RSOhub.hub.model.User;
import com.RSOhub.hub.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RequestMapping("api/auth")
@RestController
public class AuthController {
    private final UserRepository userRepository;
    private final String salt = "2w354ytw4yhyw6h";

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "login")
    public LoginResponse login(@RequestBody LoginOrRegisterRequest loginRequest) {
        try {
            String hashedPassword = encryptPassword(loginRequest.getPassword());
            User foundUser = userRepository.findByUsernameAndPassword(loginRequest.getUsername(), hashedPassword);
            if (foundUser == null) {
                return new LoginResponse(false);
            }
            return new LoginResponse(foundUser.getUsername(), foundUser.getUserType(), true);
        } catch (Exception e) {
            return new LoginResponse(false);
        }
    }

    @PostMapping(path = "register")
    public User register(@RequestBody LoginOrRegisterRequest registerRequest) {
        try {
            String hashedPassword = encryptPassword(registerRequest.getPassword());
            User newUser = new User(
                    registerRequest.getUsername(),
                    hashedPassword, registerRequest.getRefUniversityId(),
                    "STANDARD"
            );
            return userRepository.save(newUser);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping(path = "register_generic")
    public User register(@RequestBody User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            return null;
        }
    }

    private String encryptPassword(String password) throws NoSuchAlgorithmException {
        password += salt;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(password.getBytes());
        return new String(messageDigest.digest());
    }
}
