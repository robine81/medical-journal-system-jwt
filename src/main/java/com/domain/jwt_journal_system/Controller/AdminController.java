package com.domain.jwt_journal_system.Controller;

import com.domain.jwt_journal_system.Model.DTO.MedicalRecordResDTO;
import com.domain.jwt_journal_system.Model.DTO.PatientReqDTO;
import com.domain.jwt_journal_system.Model.DTO.PatientResDTO;
import com.domain.jwt_journal_system.Service.MedicalRecordService;
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
    private final PatientService patientService;
    private final MedicalRecordService medicalRecordService;

    public AdminController(PatientService patientService, MedicalRecordService medicalRecordService) {
        this.patientService = patientService;
        this.medicalRecordService = medicalRecordService;
    }

    @GetMapping("/patients")
    public ResponseEntity<List<PatientResDTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<PatientResDTO> getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatient(id));
    }

    @PostMapping("/patients")
    public ResponseEntity<PatientResDTO> createPatient(@Valid @RequestBody PatientReqDTO dto) {
        return ResponseEntity.status(201).body(patientService.createPatient(dto));
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<PatientResDTO> updatePatient(@PathVariable Long id,
                                                       @Valid @RequestBody PatientReqDTO dto) {
        return ResponseEntity.ok(patientService.updatePatient(id, dto));
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

 /*   @GetMapping("/patients/{id}/medical_records")
    public ResponseEntity<List<MedicalRecordResDTO>> getMedicalRecords(@PathVariable Long id)
    {
        return ResponseEntity.ok(medicalRecordService.)
    }*/
}