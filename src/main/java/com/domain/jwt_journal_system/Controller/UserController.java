package com.domain.jwt_journal_system.Controller;

import com.domain.jwt_journal_system.Model.DTO.PatientResDTO;
import com.domain.jwt_journal_system.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private PatientService patientService;

    // USER kan bara LÄSA patienter (inte skapa/uppdatera/ta bort)
    @GetMapping("/patients")
    public ResponseEntity<List<PatientResDTO>> getAllPatients() {
        List<PatientResDTO> patients = patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<PatientResDTO> getPatientById(@PathVariable Long id) {
        PatientResDTO patient = patientService.getPatient(id);
        return ResponseEntity.ok(patient);
    }
}