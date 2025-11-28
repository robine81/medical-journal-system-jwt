package com.domain.jwt_journal_system.Repo;

import com.domain.jwt_journal_system.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepo extends JpaRepository<Patient, Long> {
    Optional<Patient> findByPersonalNumber(String personalNumber);
    List<Patient> findByLastName(String lastName);
    List<Patient> findByFirstNameAndLastName(String first, String last);
    boolean existsByPersonalNumber(String personalNumber);
}