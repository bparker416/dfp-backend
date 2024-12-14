package com.damnfinepizzapo.damn_fine_backend.authentication;

import com.damnfinepizzapo.damn_fine_backend.dto.AuthResponse;
import com.damnfinepizzapo.damn_fine_backend.dto.LoginRequest;
import com.damnfinepizzapo.damn_fine_backend.user.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private UserRepository userRepository;

    private JwtTokenProvider jwtTokenProvider;

    private PasswordEncoder passwordEncoder;

    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return userRepository.findByUsername(loginRequest.getUsername())
                .map(user -> {
                    if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                        // Generate JWT Token
                        String token = jwtTokenProvider.createToken(user.getUsername());
                        return ResponseEntity.ok(new AuthResponse(token));
                    } else {
                        return ResponseEntity.status(401).body("Wrong login!");
                    }
                        })
                .orElse(ResponseEntity.status(401).body("User not found!"));
    }
}
