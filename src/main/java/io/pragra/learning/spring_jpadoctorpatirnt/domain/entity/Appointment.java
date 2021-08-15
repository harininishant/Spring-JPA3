package io.pragra.learning.spring_jpadoctorpatirnt.domain.entity;

import io.pragra.learning.spring_jpadoctorpatirnt.domain.StatusEnum;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.time.Instant;

@Entity // marked as an entity it is to be managed by JPA/hybernate to create table
@Table(name = "TABLE_APPT")// table name mentioned in this anotation if table name dif from classname
@Data // getter /setter
@NoArgsConstructor//JPA needs this
@Builder
@AllArgsConstructor
public class Appointment  {

    @Id // this anotation is used for primary key when compared to
    // prev databasewhere we manually key the ID as primary
    // example(student.setId(((int) Math.floor(Math.random() * 1000000)));) from prev class Student
    @GeneratedValue(strategy = GenerationType.AUTO)//system will assign the value automatically
    private  Integer id;
//    @Column(name = "FIRST_NAME", length = 50,nullable = false)// db will always ask for firstname cannot be null
//    private String firstName;
//    @Column(name = "LAST_NAME",columnDefinition = "VARCHAR(3000)")
//    private  String lastName;
//    private  String phoneNumber;
    @OneToOne//(fetch = FetchType.LAZY)
    //@JoinColumn(name = "visiting_patient")// this one joins the Id columgn to visiting patient and combines it
    //table columns were these :ID  	APPOINTMENT_DATE CREATE_DATE  STATUS UPDATE_DATE  DOCTOR_NAME_ID  VISITING_PATIENT
    private Patient patient;
    //@Transient// means it should not be paet of the column
    private Instant appointmentDate;
    private Instant createDate ;
    private Instant updateDate ;
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
       //private String doctorName;
    @ManyToOne(targetEntity =  Doctor.class,cascade = CascadeType.DETACH)// one doctor has many appmnts
    private Doctor doctorName;
    @Transient
    private double appointmentFee;

}
