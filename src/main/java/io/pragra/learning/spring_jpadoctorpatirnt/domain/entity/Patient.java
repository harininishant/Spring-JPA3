package io.pragra.learning.spring_jpadoctorpatirnt.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient extends BaseEntity{
    @Id // mapping using ID Appointment and Patient table , Appointment and Doctor table
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    @OneToMany(targetEntity = HealthCard.class)//fetch = FetchType.EAGER)// relationship for eager
    private List<HealthCard> cards;




}
