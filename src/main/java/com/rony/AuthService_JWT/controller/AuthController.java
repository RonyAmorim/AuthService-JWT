package com.rony.AuthService_JWT.controller;


import com.rony.AuthService_JWT.Service.UserService;
import com.rony.AuthService_JWT.dto.ApiResponse;
import com.rony.AuthService_JWT.dto.JwtAuthenticationResponse;
import com.rony.AuthService_JWT.dto.LoginRequestDTO;
import com.rony.AuthService_JWT.dto.SignUpRequestDTO;
import com.rony.AuthService_JWT.security.JwtTokenProvider;
import com.rony.AuthService_JWT.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final UserService userService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.userService = userService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser( @RequestBody LoginRequestDTO loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.email(),
                        loginRequest.password()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser( @RequestBody SignUpRequestDTO signUpRequest) {
        if (userService.findByEmail(signUpRequest.email()).isPresent()) {
            return new ResponseEntity<>(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User();
        user.setUsername(signUpRequest.username());
        user.setEmail(signUpRequest.email());
        user.setPassword(signUpRequest.password());
        user.setPhone(signUpRequest.phone());

        userService.saveUser(user);

        return ResponseEntity.ok(new ApiResponse(true, "User registered successfully"));
    }
}
