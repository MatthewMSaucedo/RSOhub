package com.RSOhub.hub.api;

import com.RSOhub.hub.dao.UserRepository;
import com.RSOhub.hub.dto.LoginOrRegisterRequest;
import com.RSOhub.hub.dto.LoginResponse;
import com.RSOhub.hub.model.User;
import com.RSOhub.hub.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "login")
    public LoginResponse login(@RequestBody LoginOrRegisterRequest loginRequest) {
        try {
            String hashedPassword = encryptPassword(loginRequest.getPassword());
            User foundUser = userRepository.findByUsernameAndPassword(loginRequest.getUsername(), hashedPassword);
            if (foundUser == null) {
                return new LoginResponse(false);
            }
            return new LoginResponse(foundUser.getUsername(), foundUser.getId(), foundUser.getUserType(), true);
        } catch (Exception e) {
            return new LoginResponse(false);
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "registerSuper")
    public User registerSuper(@RequestBody LoginOrRegisterRequest registerRequest) {
        try {
            String hashedPassword = encryptPassword(registerRequest.getPassword());
            User newUser = new User(
                    registerRequest.getUsername(),
                    hashedPassword, registerRequest.getRefUniversityId(),
                    "SUPER_ADMIN"
            );
            return userRepository.save(newUser);
        } catch (Exception e) {
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "registerAdmin")
    public User registerAdmin(@RequestBody LoginOrRegisterRequest registerRequest) {
        try {
            String hashedPassword = encryptPassword(registerRequest.getPassword());
            User newUser = new User(
                    registerRequest.getUsername(),
                    hashedPassword, registerRequest.getRefUniversityId(),
                    "ADMIN"
            );
            return userRepository.save(newUser);
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
