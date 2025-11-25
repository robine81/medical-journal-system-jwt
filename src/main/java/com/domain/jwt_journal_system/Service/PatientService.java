package com.domain.jwt_journal_system.Service;

import com.domain.jwt_journal_system.Model.DTO.PatientReqDTO;
import com.domain.jwt_journal_system.Model.DTO.PatientResDTO;
import com.domain.jwt_journal_system.Model.Patient;
import com.domain.jwt_journal_system.Repo.PatientRepo;
import com.domain.jwt_journal_system.exception.ResourceAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    private final PatientRepo repo;
    private final Mapper mapper;

    @Autowired
    public PatientService(PatientRepo repo, Mapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<PatientResDTO> getAll(){
        List<Patient> patients = repo.findAll();
        List<PatientResDTO> patientResDTOS = new ArrayList<>();

        for(Patient p : patients){
            patientResDTOS.add(mapper.toPatientResponseDTO(p));
        }
        return patientResDTOS;
    }

    public PatientResDTO getPatient(Long id){
        Patient patient = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        return mapper.toPatientResponseDTO(patient);
    }

    public PatientResDTO createPatient(PatientReqDTO dto){
        if(repo.existsByPersonalNumber(dto.getPersonalNumber())) {
            throw new ResourceAlreadyExistsException("Personal number " +
                    dto.getPersonalNumber() +
                    " is already registered");
        }
        return mapper.toPatientResponseDTO(repo.save(mapper.toPatientEntity(dto)));
    }

    // CRUD controller
    //application-dev
    //LoginReqDTO, AppUser, Role, CustomUserDetailService
    //JwtFilter, JwtService
    //roles, login, session

}
