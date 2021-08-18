package io.pragra.learning.spring_jpadoctorpatirnt.repo;

import io.pragra.learning.spring_jpadoctorpatirnt.domain.entity.Appointment;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApptRepo  extends JpaRepository<Appointment,Integer> {
    @Cacheable(value = "appointment")// hybernate caching
    /*
    @Cacheable annotation is that you use it to mark the method return values
     that will be stored in the cache.
     The @Cacheable annotation can be applied either at method or type level.
     */
    //hybernate query
    @Query("select a from Appointment a  where  a.doctorName.firstName =:name")// hybernate query language
    List<Appointment> findAllByDoctorName(@Param("name") String name);// custom method
    //@Param is parameter
    //SELECT COUT(*) FROM TABLE_APPT
    //SELECT COUNT(A)FROM APPOINTMENT A

    //native query
    @Query(value = "select a.* from table_appt a, doctor b where  b.first_name =: name and a.doctor_name_id = b.id",nativeQuery = true)// hybernate query language
    List<Appointment> findByNativeQuery(@Param("name") String name);

}
