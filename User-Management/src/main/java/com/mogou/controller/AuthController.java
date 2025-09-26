package com.mogou.controller;

import com.mogou.dto.JwtResponse;
import com.mogou.dto.LoginRequest;
import com.mogou.dto.SignupRequest;
import com.mogou.model.User;
import com.mogou.repository.UserRepository;
import com.mogou.security.JwtUtils;
import com.mogou.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public AuthController(UserService userService, UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtils jwtUtils){
        this.userService = userService; this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder; this.jwtUtils = jwtUtils;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Map<String,String> req){
        User created = userService.create(req.get("name"), req.get("email"), req.get("password"));
        return ResponseEntity.ok(created);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest req){
        var opt = userRepository.findByEmail(req.email);
        if(opt.isEmpty() || !passwordEncoder.matches(req.password, opt.get().getPassword())){
            return ResponseEntity.status(401).body("Invalid credentials");
        }
        User u = opt.get();
        String token = jwtUtils.generateToken(u.getEmail());
        return ResponseEntity.ok(new JwtResponse(token, "Bearer", u.getId(), u.getEmail(), u.getRole().name()));
    }
}