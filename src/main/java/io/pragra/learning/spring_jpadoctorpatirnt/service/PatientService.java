package io.pragra.learning.spring_jpadoctorpatirnt.service;

import io.pragra.learning.spring_jpadoctorpatirnt.domain.entity.Doctor;
import io.pragra.learning.spring_jpadoctorpatirnt.domain.entity.HealthCard;
import io.pragra.learning.spring_jpadoctorpatirnt.domain.entity.Patient;
import io.pragra.learning.spring_jpadoctorpatirnt.repo.HealthRepo;
import io.pragra.learning.spring_jpadoctorpatirnt.repo.PatientRepo;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
@Service
public class PatientService {
    private PatientRepo repo;


    public PatientService(PatientRepo repo) {
        this.repo = repo;
    }


    public Patient createPatient(Patient patient) {
        return repo.save(patient);

    }

    public Patient fincById(Long id) {
        return repo.findById(id).get();

    }

    public List<Patient> getAll() {
        return repo.findAll();
    }

//    public Patient CreateHealthCard(Patient healthCard) {
//        healthCard.setCards(healthCard.getCards());
//        return repo.save(healthCard);
//
//    }
}

