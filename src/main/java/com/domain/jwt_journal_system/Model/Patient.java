package com.domain.jwt_journal_system.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String personalNumber;
    private String phoneNumber;
    private String email;
    private String address;

    //fortsätt här
}
