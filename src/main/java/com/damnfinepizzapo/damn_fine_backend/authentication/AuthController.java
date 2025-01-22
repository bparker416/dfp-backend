package com.damnfinepizzapo.damn_fine_backend.authentication;

import com.azure.core.annotation.Get;
import com.damnfinepizzapo.damn_fine_backend.dto.AuthResponse;
import com.damnfinepizzapo.damn_fine_backend.dto.LoginRequest;
import com.damnfinepizzapo.damn_fine_backend.user.CustomUserDetailsService;
import com.damnfinepizzapo.damn_fine_backend.user.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/api/public/auth")
@CrossOrigin(origins = "https://gray-sand-09b550110.4.azurestaticapps.net")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        try {
            System.out.println("Login request received: " + loginRequest.getUsername());

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );

            // Store authentication in session
            SecurityContextHolder.getContext().setAuthentication(authentication);
            session.setAttribute("USER", authentication.getName());

            System.out.println(session.getId());

            return ResponseEntity.ok(new AuthResponse("Login successful!"));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body(new AuthResponse("Bad credentials!"));
        }
    }

    @GetMapping("/check")
    public ResponseEntity<?> check(HttpSession session) {
        if (session.getAttribute("USER") != null) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logout successful!");
    }

    @GetMapping("/login")
    public ResponseEntity<String> getLoginPage() {
        return ResponseEntity.ok("It works!");
    }

}
