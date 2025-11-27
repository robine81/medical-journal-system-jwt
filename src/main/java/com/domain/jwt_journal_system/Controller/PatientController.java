package com.domain.jwt_journal_system.Controller;

import com.domain.jwt_journal_system.Model.DTO.PatientReqDTO;
import com.domain.jwt_journal_system.Model.DTO.PatientResDTO;
import com.domain.jwt_journal_system.Service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api")
public class PatientController {
    private final PatientService service;

    public PatientController(PatientService service) { this.service = service; }

    @GetMapping("/admin/patients")
    public ResponseEntity<List<PatientResDTO>> getAll(){ return ResponseEntity
            .ok(service.getAll()); }

    @GetMapping("/admin/{id}")
    public ResponseEntity<PatientResDTO> getById(@PathVariable Long id){ return ResponseEntity.ok(service.getPatient(id)); }

    @PostMapping ResponseEntity<PatientResDTO> createPatient(@Valid @RequestBody PatientReqDTO dto){
        return ResponseEntity.status(201).body(service.createPatient(dto));
    }
}