package com.domain.jwt_journal_system.Model.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class MedicalRecordReqDTO {
    @NotNull(message = "Patient ID must be provided")
    @Min(value = 1, message = "Patient ID must be a positive number")
    private Long patientId;
    @NotBlank(message = "Diagnosis must be provided")
    @Size(min = 3, message = "Diagnosis must contain at least 10 characters")
    private String diagnosis;
    private String treatment;
    private String notes;
    @NotNull(message = "Record date must be provided")
    private LocalDate recordDate;

    public MedicalRecordReqDTO() {}

    public @NotNull(message = "Patient ID must be provided") @Min(value = 1, message = "Patient ID must be a positive number") Long getPatientId() {
        return patientId;
    }

    public void setPatientId(@NotNull(message = "Patient ID must be provided") @Min(value = 1, message = "Patient ID must be a positive number") Long patientId) {
        this.patientId = patientId;
    }

    public @NotBlank(message = "Diagnosis must be provided") @Size(min = 3, message = "Diagnosis must contain at least 10 characters") String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(@NotBlank(message = "Diagnosis must be provided") @Size(min = 3, message = "Diagnosis must contain at least 10 characters") String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public @NotNull(message = "Record date must be provided") LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(@NotNull(message = "Record date must be provided") LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    @Override
    public String toString() {
        return "MedicalRecordReqDTO{" +
                "patientId=" + patientId +
                ", diagnosis='" + diagnosis + '\'' +
                ", treatment='" + treatment + '\'' +
                ", notes='" + notes + '\'' +
                ", recordDate=" + recordDate +
                '}';
    }
}
