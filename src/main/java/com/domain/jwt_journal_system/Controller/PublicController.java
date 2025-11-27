package com.domain.jwt_journal_system.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {
    @GetMapping("/public/test")
    public ResponseEntity<String> publicEndpoint() {
        return ResponseEntity.ok("Public endpoint - no auth needed");
    }

    @GetMapping("/")
    public ResponseEntity<String> root(){
        return ResponseEntity.ok("Welcome to Patient Journal API");
    }
}
