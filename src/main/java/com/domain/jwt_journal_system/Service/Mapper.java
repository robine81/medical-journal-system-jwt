package com.domain.jwt_journal_system.Service;

import com.domain.jwt_journal_system.Model.DTO.MedicalRecordReqDTO;
import com.domain.jwt_journal_system.Model.DTO.MedicalRecordResDTO;
import com.domain.jwt_journal_system.Model.DTO.PatientReqDTO;
import com.domain.jwt_journal_system.Model.DTO.PatientResDTO;
import com.domain.jwt_journal_system.Model.MedicalRecord;
import com.domain.jwt_journal_system.Model.Patient;
import com.domain.jwt_journal_system.Repo.MedicalRecordRepo;
import com.domain.jwt_journal_system.Repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    private final PatientRepo patientRepo;
    private final MedicalRecordRepo medicalRecordRepo;

    @Autowired
    public Mapper(PatientRepo patientRepo, MedicalRecordRepo medicalRecordRepo) {
        this.patientRepo = patientRepo;
        this.medicalRecordRepo = medicalRecordRepo;
    }

    public PatientResDTO patchPatient(Long id, PatientReqDTO dto) {
        Patient patient = patientRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient with id: " + id + " not found"));

        if(dto.getFirstName() != null) patient.setFirstName(dto.getFirstName());
        if(dto.getLastName() != null)patient.setLastName(dto.getLastName());
        if(dto.getPersonalNumber() != null) patient.setPersonalNumber(dto.getPersonalNumber());
        if(dto.getPhoneNumber() != null) patient.setPhoneNumber(dto.getPhoneNumber());
        if(dto.getEmail() != null) patient.setEmail(dto.getEmail());
        if(dto.getAddress() != null) patient.setAddress(dto.getAddress());

        Patient saved = patientRepo.save(patient);
        return toPatientResponseDTO(saved);
    }

    public PatientResDTO toPatientResponseDTO(Patient patient){
            return new PatientResDTO(patient.getId(), patient.getFirstName(), patient.getLastName(), patient.getPersonalNumber(), patient.getPhoneNumber(), patient.getEmail(), patient.getAddress());
    }

    public Patient toPatientEntity(PatientReqDTO patientReqDTO){
            Patient patient = new Patient();

            patient.setFirstName(patientReqDTO.getFirstName());
            patient.setLastName(patientReqDTO.getLastName());
            patient.setPersonalNumber(patientReqDTO.getPersonalNumber());
            patient.setPhoneNumber(patientReqDTO.getPhoneNumber());
            patient.setEmail(patientReqDTO.getEmail());
            patient.setAddress(patientReqDTO.getAddress());

            return patient;
        }

    public MedicalRecordResDTO patchMedicalRecord(Long id, MedicalRecordReqDTO dto) {
        MedicalRecord medicalRecord = medicalRecordRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Medical record with id: " + id + " not found"));

        Patient patient = patientRepo.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        medicalRecord.setPatient(patient);
        if(dto.getDiagnosis() != null) medicalRecord.setDiagnosis(dto.getDiagnosis());
        if(dto.getTreatment() != null) medicalRecord.setTreatment(dto.getTreatment());
        if(dto.getNotes() != null) medicalRecord.setNotes(dto.getNotes());
        if(dto.getRecordDate() != null) medicalRecord.setRecordDate(dto.getRecordDate());

        MedicalRecord saved = medicalRecordRepo.save(medicalRecord);
        return toMedicalRecordResponseDTO(saved);
    }

    public MedicalRecordResDTO toMedicalRecordResponseDTO(MedicalRecord medicalRecord){
        return new MedicalRecordResDTO(
                medicalRecord.getId(),
                medicalRecord.getPatient().getId(),
                medicalRecord.getDiagnosis(),
                medicalRecord.getTreatment(),
                medicalRecord.getNotes(),
                medicalRecord.getRecordDate(),
                medicalRecord.getCreatedBy());
    }

    public MedicalRecord toMedicalRecordEntity(MedicalRecordReqDTO dto){
        MedicalRecord medicalRecord = new MedicalRecord();

        Patient patient = patientRepo.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        medicalRecord.setPatient(patient);
        medicalRecord.setDiagnosis(dto.getDiagnosis());
        medicalRecord.setTreatment(dto.getTreatment());
        medicalRecord.setNotes(dto.getNotes());
        medicalRecord.setRecordDate(dto.getRecordDate());

        return medicalRecord;
    }
}