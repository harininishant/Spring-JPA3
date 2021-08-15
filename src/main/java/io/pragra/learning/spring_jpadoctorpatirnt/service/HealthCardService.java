package io.pragra.learning.spring_jpadoctorpatirnt.service;

import io.pragra.learning.spring_jpadoctorpatirnt.domain.entity.HealthCard;
import io.pragra.learning.spring_jpadoctorpatirnt.domain.entity.Patient;
import io.pragra.learning.spring_jpadoctorpatirnt.repo.HealthRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthCardService {

    private HealthRepo repo;

    public HealthCardService(HealthRepo repo) {
        this.repo = repo;
    }

    public HealthCard CreateHealthCard(HealthCard healthCard){ ;
        return repo.save(healthCard);

    }

    public HealthCard findById(Long id){
        return repo.findById(id).get();

    }

    public List<HealthCard> getAll(){
        return repo.findAll();
    }



}
