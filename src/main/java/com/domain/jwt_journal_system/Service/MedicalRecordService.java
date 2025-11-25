package com.domain.jwt_journal_system.Service;

import com.domain.jwt_journal_system.Repo.MedicalRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService {
    private final MedicalRecordRepo repo;
    private final Mapper mapper;

    @Autowired
    public MedicalRecordService(MedicalRecordRepo repo, Mapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    // När skapar journal för att sätta createdBy genom jwt login
    //String currentUser = SecurityContextHolder.getContext()
      //      .getAuthentication().getName();

    //medicalRecord.setCreatedBy(currentUser);
}
