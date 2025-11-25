package com.domain.jwt_journal_system.Model.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientReqDTO {
    @NotBlank(message = "First name must be provided")
    @Size(min = 2, message = "First name must contain at least 2 characters")
    private String firstName;
    @NotBlank(message = "First name must be provided")
    @Size(min = 2, message = "First name must contain at least 2 characters")
    private String lastName;
    @NotBlank(message = "Personal number must be provided")
    @Size(min = 12, max = 13, message = "Personal number must be between 12-13 characters")
    private String personalNumber;
    @NotBlank(message = "Phone number must be provided")
    @Size(min = 10, message = "Phone number must contain at least 10 characters")
    private String phoneNumber;
    @Email
    @NotBlank(message = "Email name must be provided")
    private String email;
    @NotBlank(message = "Address must be provided")
    @Size(min = 5, message = "Address must contain at least 5 characters")
    private String address;

    public PatientReqDTO() {}

    public PatientReqDTO(String firstName, String lastName, String personalNumber, String phoneNumber, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalNumber = personalNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public @NotBlank(message = "First name must be provided") @Size(min = 2, message = "First name must contain at least 2 characters") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "First name must be provided") @Size(min = 2, message = "First name must contain at least 2 characters") String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank(message = "First name must be provided") @Size(min = 2, message = "First name must contain at least 2 characters") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "First name must be provided") @Size(min = 2, message = "First name must contain at least 2 characters") String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank(message = "Personal number must be provided") @Size(min = 12, max = 13, message = "Personal number must be between 12-13 characters") String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(@NotBlank(message = "Personal number must be provided") @Size(min = 12, max = 13, message = "Personal number must be between 12-13 characters") String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public @NotBlank(message = "Phone number must be provided") @Size(min = 10, message = "Phone number must contain at least 10 characters") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotBlank(message = "Phone number must be provided") @Size(min = 10, message = "Phone number must contain at least 10 characters") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @Email @NotBlank(message = "Email name must be provided") String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotBlank(message = "Email name must be provided") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Address must be provided") @Size(min = 5, message = "Address must contain at least 5 characters") String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "Address must be provided") @Size(min = 5, message = "Address must contain at least 5 characters") String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PatientReqDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personalNumber='" + personalNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
