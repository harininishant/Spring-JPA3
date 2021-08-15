package io.pragra.learning.spring_jpadoctorpatirnt.repo;

import io.pragra.learning.spring_jpadoctorpatirnt.domain.entity.Appointment;
import io.pragra.learning.spring_jpadoctorpatirnt.domain.entity.Doctor;
import io.pragra.learning.spring_jpadoctorpatirnt.domain.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {


}
