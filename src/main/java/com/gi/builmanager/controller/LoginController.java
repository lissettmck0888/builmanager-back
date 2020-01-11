package com.gi.builmanager.controller;

import com.gi.builmanager.dto.Credenciales;
import com.gi.builmanager.security.BuilManagerUserDetailsService;
import com.gi.builmanager.security.CustomUserDetails;
import com.gi.builmanager.security.JwtManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = {"*"})
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtManager jwtManager;

    @PostMapping("")
    public String login(@RequestBody Credenciales credenciales) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credenciales.getUserName(), credenciales.getPassword()));
        if(authentication != null) {
            LOGGER.info("isAuthenticated=" + authentication.isAuthenticated());
            return jwtManager.generateToken((CustomUserDetails) authentication.getPrincipal());
        }

        return null;
    }
}
