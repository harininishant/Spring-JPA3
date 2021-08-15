package io.pragra.learning.spring_jpadoctorpatirnt.service;

import io.pragra.learning.spring_jpadoctorpatirnt.domain.entity.Doctor;
import io.pragra.learning.spring_jpadoctorpatirnt.repo.DoctorRepo;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorService {
    private DoctorRepo repo;

    public DoctorService(DoctorRepo repo) {
        this.repo = repo;
    }

    public Doctor createDoctor(Doctor doctor){
        return repo.save(doctor);

    }

    public Doctor fincById(Long id){
        return repo.findById(id).get();

    }

    public List<Doctor> getAll(){
        return repo.findAll();
    }
}
