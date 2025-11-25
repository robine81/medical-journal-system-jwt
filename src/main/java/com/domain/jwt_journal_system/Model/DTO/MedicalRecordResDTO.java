package com.domain.jwt_journal_system.Model.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MedicalRecordResDTO {
    private Long id;
    private Long patientId;
    private String diagnosis;
    private String treatment;
    private String notes;
    private LocalDate recordDate;
    private String createdBy;

    public MedicalRecordResDTO() {}

    public MedicalRecordResDTO(Long id, Long patientId, String diagnosis, String treatment, String notes, LocalDate recordDate, String createdBy) {
        this.id = id;
        this.patientId = patientId;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.notes = notes;
        this.recordDate = recordDate;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
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

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "MedicalRecordResDTO{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", diagnosis='" + diagnosis + '\'' +
                ", treatment='" + treatment + '\'' +
                ", notes='" + notes + '\'' +
                ", recordDate=" + recordDate +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
