package com.vmo_intern.manage_fresher.apis;

import java.util.ArrayList;
import java.util.Objects;

import com.vmo_intern.manage_fresher.configs.WebSecurityConfig;
import com.vmo_intern.manage_fresher.configs.jwt.JwtTokenUtil;
import com.vmo_intern.manage_fresher.models.dto_entities.AuthenticationEntityDto;
import com.vmo_intern.manage_fresher.models.entities.AuthenticationEntity;
import com.vmo_intern.manage_fresher.models.entities.UserEntity;
import com.vmo_intern.manage_fresher.models.jwt.JwtRequest;
import com.vmo_intern.manage_fresher.models.jwt.JwtResponse;
import com.vmo_intern.manage_fresher.models.result.Result;
import com.vmo_intern.manage_fresher.models.result.ResultGenerator;
import com.vmo_intern.manage_fresher.services.AuthenticationService;
import com.vmo_intern.manage_fresher.services.JwtUserDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(value = "/authenticate")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationService authenticationService;

    private ModelMapper modelMapper = new ModelMapper();

    public JwtAuthenticationController() {
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }
    @PostMapping("")
    public Result<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResultGenerator.genSuccessResult(new JwtResponse(token));
    }

    @PostMapping("/register")
    public Result<AuthenticationEntity> register(@RequestBody AuthenticationEntityDto authenticationEntityDto) throws Exception {
        String passwordEncoded = WebSecurityConfig.passwordEncoder().encode(authenticationEntityDto.getPassword());
        authenticationEntityDto.setPassword(passwordEncoded);
        AuthenticationEntity entity = modelMapper.map(authenticationEntityDto, AuthenticationEntity.class);
        AuthenticationEntity result = authenticationService.save(entity);
        if (result == null) return ResultGenerator.genFailResult("username existed");
        return ResultGenerator.genSuccessResult(result);
    }

    private void authenticate(String username, String password) throws Exception {
        AuthenticationEntity authenticationEntity = authenticationService.findByUsername(username);
        if (authenticationEntity != null) {
            if (WebSecurityConfig.passwordEncoder().matches(password, authenticationEntity.getPassword())) {

            } else {
                throw new UsernameNotFoundException("Wrong password");
            }
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
