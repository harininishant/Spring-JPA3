package io.pragra.learning.spring_jpadoctorpatirnt.repo;

import io.pragra.learning.spring_jpadoctorpatirnt.domain.entity.Doctor;
import io.pragra.learning.spring_jpadoctorpatirnt.domain.entity.HealthCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthRepo extends JpaRepository<HealthCard,Long> {

}
