package com.dm.demojpa.repository;

import com.dm.demojpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


     Object findByFirstName(String name);

     Object findByFirstNameContaining(String name);

     Object findByLastNameNotNull();
     //JPQL
     @Query("select s from Student s where s.email=?1")
     Student findByEmailAddress(String email);
     //Native query
     @Query(
             value = "SELECT * FROM STUDENT s where s.EMAIL_ADRESS=?1",
             nativeQuery = true
     )
     Student findByEmailAddressNative(String email);
     //Native query named param
     @Query(
             value = "SELECT * FROM STUDENT s where s.EMAIL_ADRESS=:email",
             nativeQuery = true
     )
     Student findByEmailAddressNativeNamedParam(@Param("email") String email);
     //Update Record
     @Modifying
     @Transactional
     @Query(
             value = "update Student set FIRST_NAME=?1 where EMAIL_ADRESS=?2",
             nativeQuery = true
     )
     int updateStudentwithEmail(String firstName,String email);






}
