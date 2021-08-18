package io.pragra.learning.spring_jpadoctorpatirnt.service;

import io.pragra.learning.spring_jpadoctorpatirnt.domain.StatusEnum;
import io.pragra.learning.spring_jpadoctorpatirnt.domain.entity.Appointment;
import io.pragra.learning.spring_jpadoctorpatirnt.repo.ApptRepo;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
  private   ApptRepo repo;
   private PatientService service;


    public AppointmentService(ApptRepo repo, PatientService service) {
        this.repo = repo;
        this.service = service;
    }

    public Appointment createAppointment(Appointment appointment){

        if (appointment.getPatient().getFirstName()== null){
            throw new IllegalArgumentException("First name cant be null");
        }
        appointment.setCreateDate(Instant.now());
        appointment.setUpdateDate(Instant.now());
        if ( appointment.getAppointmentDate().compareTo(Instant.now())==-1){
            throw new IllegalArgumentException("Incorrect Appointment");
        }
        appointment.setPatient(service.createPatient(appointment.getPatient()));
        appointment.setStatus(StatusEnum.ORIGINAL);
        repo.save(appointment);
        return appointment;
    }
    public Appointment updateAppointment(Appointment appointment){

//        if (appointment.getFirstName()== null){
//            throw new IllegalArgumentException("First name cant be null");
//        }
        appointment.setUpdateDate(Instant.now());
//        if ( appointment.getAppointmentDate().compareTo(Instant.now())==-1){
//            throw new IllegalArgumentException("appointment cannot be in the past");
//        }
        appointment.setStatus(StatusEnum.RESCHEDULED);
        return repo.save(appointment);
    }

    public Appointment getById(int id){

        if (id> 0){
            throw new IllegalArgumentException("Id cant be negative");
        }

        return repo.findById(id).orElseThrow(IllegalAccessError::new);
    }

    public List<Appointment> findAll() {
        return repo.findAll();
    }

    public List<Appointment> getAllForDoctorName(String doctorFirstname){
      // return repo.findAll().stream().filter(a->a.getDoctorName().getFirstName().toUpperCase().matches(doctorFirstname.toUpperCase())).collect(Collectors.toList());
         return repo.findAllByDoctorName(doctorFirstname.toUpperCase());// Aptrepo has a LIst from which we are calling the method
       // return repo.findByNativeQuery(doctorFirstname.toUpperCase());
    }


}
