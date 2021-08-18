package io.pragra.learning.spring_jpadoctorpatirnt;

import io.pragra.learning.spring_jpadoctorpatirnt.domain.entity.Appointment;
import io.pragra.learning.spring_jpadoctorpatirnt.repo.ApptRepo;
import io.pragra.learning.spring_jpadoctorpatirnt.service.AppointmentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

import java.time.Duration;
import java.time.Instant;

@SpringBootApplication
@EnableCaching
public class SpringJpaDoctorPatirntApplication {
    private ApptRepo repo;

    public SpringJpaDoctorPatirntApplication(ApptRepo repo) {
        this.repo = repo;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaDoctorPatirntApplication.class, args);
//       ApplicationContext context =  SpringApplication.run(SpringJpaDoctorPatirntApplication.class, args);
//        AppointmentService service = context.getBean(AppointmentService.class);
// service.findAll().stream().map(appointment -> appointment.getPatient()).forEach(System.out::println);
       // service.findAll().stream().forEach(System.out::println);// for fetch lazy
    }

//
//    @Bean
//    CommandLineRunner runner() {
//        return args ->{
//            Appointment appointment= Appointment.builder().firstName("harini").lastName("nishant")
//                    .appointmentDate(Instant.now().plus(Duration.ofDays(2)))
//                    .createDate(Instant.now()).updateDate(Instant.now()).build();
//            repo.save(appointment);
//        };
//    }
//
    /*
     CommandLineRunner runner()  returns void however we are using it to return args ?
     answer: we are not returning void here we are returning the bean and returning lambda.
     example:  CommandLineRunner runner = new runner;
     runner = arg->{}
     hence return arg->{}.
     */

}
