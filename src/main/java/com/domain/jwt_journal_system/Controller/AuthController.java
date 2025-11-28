package com.domain.jwt_journal_system.Controller;

import com.domain.jwt_journal_system.Model.AppUser;
import com.domain.jwt_journal_system.Model.DTO.AuthResDTO;
import com.domain.jwt_journal_system.Model.DTO.LoginReqDTO;
import com.domain.jwt_journal_system.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<AuthResDTO> login(@RequestBody LoginReqDTO loginReq)
    {
        Authentication auth = authenticationManager.authenticate(new
                UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword()));

        String role = auth.getAuthorities().iterator().next().getAuthority().replace("ROLE_", "");
        String token = jwtUtil.generateToken(loginReq.getUsername(), role);

        return ResponseEntity.ok(new AuthResDTO(token));
    }

}