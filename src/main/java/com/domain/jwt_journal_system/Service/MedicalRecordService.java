package com.domain.jwt_journal_system.Service;

import com.domain.jwt_journal_system.Model.DTO.MedicalRecordResDTO;
import com.domain.jwt_journal_system.Model.DTO.PatientResDTO;
import com.domain.jwt_journal_system.Model.MedicalRecord;
import com.domain.jwt_journal_system.Model.Patient;
import com.domain.jwt_journal_system.Repo.MedicalRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalRecordService {
    private final MedicalRecordRepo repo;
    private final Mapper mapper;

    @Autowired
    public MedicalRecordService(MedicalRecordRepo repo, Mapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<MedicalRecordResDTO> getAllMedicalRecords()
    {
        List<MedicalRecord> medicalRecord = repo.findAll();
        List<MedicalRecordResDTO> medicalRecordResDTOS = new ArrayList<>();

        for(MedicalRecord m : medicalRecord){
            medicalRecordResDTOS.add(mapper.toMedicalRecordResponseDTO(m));
        }
        return medicalRecordResDTOS;
    }

    // När skapar journal för att sätta createdBy genom jwt login
    //String currentUser = SecurityContextHolder.getContext()
    //      .getAuthentication().getName();

    //medicalRecord.setCreatedBy(currentUser);
}