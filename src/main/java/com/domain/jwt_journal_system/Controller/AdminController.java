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
@RequestMapping("/api/admin")
public class AdminController {
    private final PatientService service;

    public AdminController(PatientService service) {
        this.service = service;
    }

    @GetMapping("/patients")
    public ResponseEntity<List<PatientResDTO>> getAllPatients() {
        return ResponseEntity.ok(service.getAllPatients());
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<PatientResDTO> getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPatient(id));
    }

    @PostMapping("/patients")
    public ResponseEntity<PatientResDTO> createPatient(@Valid @RequestBody PatientReqDTO dto) {
        return ResponseEntity.status(201).body(service.createPatient(dto));
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<PatientResDTO> updatePatient(@PathVariable Long id,
                                                       @Valid @RequestBody PatientReqDTO dto) {
        return ResponseEntity.ok(service.updatePatient(id, dto));
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        service.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}