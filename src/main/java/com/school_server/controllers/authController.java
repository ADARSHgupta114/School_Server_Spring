package com.school_server.controllers;


import com.school_server.entity.User;
import com.school_server.entity.Role;
import com.school_server.payload.SignDTO;
import com.school_server.payload.loginDTO;
import com.school_server.repository.userRepository;
import com.school_server.repository.roleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/auth")
public class authController {
    @Autowired
    private AuthenticationManager authenticationmanager;
    @Autowired
    private userRepository loginrepository;
    @Autowired
    private PasswordEncoder passwordencoder;
    @Autowired
    private roleRepository rolerepository;
    @PostMapping("/sign-up")
    public ResponseEntity<?> singupAdmin(@RequestBody SignDTO signdto){
        if(loginrepository.existsByEmail(signdto.getEmail()))
            return new ResponseEntity<>("Email Already Used", HttpStatus.INTERNAL_SERVER_ERROR);
        User login = new User();
        login.setEmail(signdto.getEmail());
        login.setPassword(passwordencoder.encode(signdto.getPassword()));
        Role role = rolerepository.findByName("ROLE_ADMIN").get();
        Set<Role> setrole = new HashSet<>();
        setrole.add(role);
        login.setRoles(setrole);
        loginrepository.save(login);
        return new ResponseEntity<>("Admin Registered Successfully",HttpStatus.OK);
    }

    @PostMapping("/sigin-in")
    public ResponseEntity<?> singinAdmin(@RequestBody loginDTO logindto){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(logindto.getEmail(),logindto.getPassword());
        Authentication authenticate = authenticationmanager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return new ResponseEntity<>("Login Successfully",HttpStatus.OK);
    }

}
