package com.SFM.Student_Management.Controllers;

import com.SFM.Student_Management.dto.AuthenticationRequest;
import com.SFM.Student_Management.dto.AuthenticationResponse;
import com.SFM.Student_Management.service.jwt.UserDetailService;
import com.SFM.Student_Management.utils.JwtUtils;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private  UserDetailService userDetailService;
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/Authenticate")
    public AuthenticationResponse createAuthentication(@RequestBody AuthenticationRequest authenticationRequest) throws IOException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),authenticationRequest.getPassword()));
        } catch (BadCredentialsException e){
            throw new BadCredentialsException("incorrect Username or password");
        } catch (DisabledException disabledException){
            log.error("User is not created");
            return null;
        }
        final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getEmail());
        final String jwt = jwtUtils.generateToken(userDetails.getUsername());
        return AuthenticationResponse.builder().accessToken(jwt).type("Bearer").expiredIn(0).build();
    }
}
