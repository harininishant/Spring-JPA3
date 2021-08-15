package io.pragra.learning.spring_jpadoctorpatirnt.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
@Getter
@Setter
public class BaseEntity {
    protected Instant createDate ;
    protected Instant updateDate ;

}
