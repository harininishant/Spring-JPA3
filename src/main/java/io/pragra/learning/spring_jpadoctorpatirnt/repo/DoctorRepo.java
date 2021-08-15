package io.pragra.learning.spring_jpadoctorpatirnt.repo;

import io.pragra.learning.spring_jpadoctorpatirnt.domain.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Long> {
}
