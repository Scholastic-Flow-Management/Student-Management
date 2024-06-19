package com.SFM.Student_Management.Controllers;

import com.SFM.Student_Management.dto.AuthenticationRequest;
import com.SFM.Student_Management.dto.AuthenticationResponse;
import com.SFM.Student_Management.service.jwt.UserDetailService;
import com.SFM.Student_Management.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private  UserDetailService userDetailService;
    @Autowired
    private   JwtUtil jwtUtil;

    @PostMapping("/Authenticate")
    public AuthenticationResponse createAuthentication(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws IOException {
            try{
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),authenticationRequest.getPassword()));
            }catch (BadCredentialsException e){
                throw new BadCredentialsException("incorrect Username or password");
            }catch (DisabledException disabledException){
               response.sendError(HttpServletResponse.SC_NOT_FOUND, "User is not created");
                return null;
            }
        final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getEmail());
            final String jwt = jwtUtil.generateToken(userDetails.getUsername());
            return new AuthenticationResponse(jwt);
    }
}
