package com.domain.jwt_journal_system.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "medical_records")
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;
    private String diagnosis;
    private String treatment;
    private String notes;
    private LocalDate recordDate;
    private String createdBy;

    public MedicalRecord() {}

    public MedicalRecord(Long id, Patient patient, String diagnosis, String treatment, String notes, LocalDate recordDate, String createdBy) {
        this.id = id;
        this.patient = patient;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.notes = notes;
        this.recordDate = recordDate;
        this.createdBy = createdBy;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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
        return "MedicalRecord{" +
                "id=" + id +
                ", patient=" + patient +
                ", diagnosis='" + diagnosis + '\'' +
                ", treatment='" + treatment + '\'' +
                ", notes='" + notes + '\'' +
                ", recordDate=" + recordDate +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
