package com.domain.jwt_journal_system.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "patient")
    private List<MedicalRecord> medicalRecords;
    private String firstName;
    private String lastName;
    private String personalNumber;
    private String phoneNumber;
    private String email;
    private String address;

    public Patient() {}

    public Patient(Long id, String firstName, String lastName, String personalNumber, String phoneNumber, String email, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalNumber = personalNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Patient(Long id, List<MedicalRecord> medicalRecords, String firstName, String lastName, String personalNumber, String phoneNumber, String email, String address) {
        this.id = id;
        this.medicalRecords = medicalRecords;
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalNumber = personalNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", medicalRecords=" + medicalRecords +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personalNumber='" + personalNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}