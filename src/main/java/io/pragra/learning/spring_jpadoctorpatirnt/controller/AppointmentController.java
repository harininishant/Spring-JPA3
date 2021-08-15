package io.pragra.learning.spring_jpadoctorpatirnt.controller;

import io.pragra.learning.spring_jpadoctorpatirnt.domain.entity.Appointment;
import io.pragra.learning.spring_jpadoctorpatirnt.domain.entity.HealthCard;
import io.pragra.learning.spring_jpadoctorpatirnt.domain.entity.Patient;
import io.pragra.learning.spring_jpadoctorpatirnt.service.AppointmentService;
import io.pragra.learning.spring_jpadoctorpatirnt.service.HealthCardService;
import io.pragra.learning.spring_jpadoctorpatirnt.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {

    private AppointmentService service;//injecting the interface that implements JPA



    public AppointmentController(AppointmentService service) {
        this.service = service;
    }



    @GetMapping("/appointment/all")
    public List<Appointment> getAllAppointment(){
        return service.findAll();
    }

    @GetMapping("/appointment/{id}")
    public Appointment getById(@PathVariable int id){
        return service.getById(id);
    }


    @PostMapping("/appointment")// updating single appointment
    public  Appointment createAppointment(@RequestBody Appointment appointment){
        return this.service.createAppointment(appointment);// save methos will save in database
    }
    @GetMapping("/appointment/doctor/{doctorname}")
    public List<Appointment> getAllForDoctorName(@PathVariable String doctorname){
        return service.getAllForDoctorName(doctorname);
    }

    @PostMapping("/appointment/update")
    public Appointment updateAppointment(@RequestBody Appointment appointment){
        return service.updateAppointment(appointment);
    }


}
