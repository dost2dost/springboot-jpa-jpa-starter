package com.dm.demojpa.controllers;

import com.dm.demojpa.entity.Guardian;
import com.dm.demojpa.entity.Student;
import com.dm.demojpa.model.Users;
import com.dm.demojpa.repository.StudentRepository;
import com.dm.demojpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("/hello")
    public ResponseEntity<Student> hellodisp(){
            Student student=Student.builder()
                    //.id(Long.valueOf(1))
                    .firstName("dost")
                    .lastName("M")
                    .email("xyz@yahoo.com")
                    .build();
            Student student2=studentRepository.save(student);
        return ResponseEntity.ok(student2);
    }
    @GetMapping("/student/{name}")
    public ResponseEntity findStudent(@PathVariable String name){

        return ResponseEntity.ok(studentRepository.findByFirstNameContaining(name));
    }
    @GetMapping("/studentbyemail/{email}")
    public ResponseEntity findByEmail(@PathVariable String email){

        return ResponseEntity.ok(studentRepository.findByEmailAddress(email));
    }
    @GetMapping("/studentbyemailNative/{email}")
    public ResponseEntity findByEmailNative(@PathVariable String email){

        return ResponseEntity.ok(studentRepository.findByEmailAddressNative(email));
    }
    @GetMapping("/studentbyemailNativeparam")
    public ResponseEntity findByEmailNativeParam(@RequestParam("email") String email){

        return ResponseEntity.ok(studentRepository.findByEmailAddressNativeNamedParam(email));
    }
    @PutMapping("/updateStudent")
    public ResponseEntity findByEmailNativeParam(@RequestParam("name") String name,@RequestParam("email") String email){

        return ResponseEntity.ok(studentRepository.updateStudentwithEmail(name,email));
    }
    @GetMapping("/lastnamenotnull")
    public ResponseEntity findStudentByLastNameNotNull(){
        return ResponseEntity.ok(studentRepository.findByLastNameNotNull());
    }
    @GetMapping("/saveStudentWithGuardian")
    public ResponseEntity saveStudentWithGuardian(){
        Guardian guardian=Guardian.builder()
                .name("kasif")
                .email("gard@yahoo.com")
                .mobile("45446")
                .email("dm@yahoo.com")
                .build();

        Student student=Student.builder()
                .firstName("Ali")
                .lastName("Khan")
                .guardian(guardian)
                .email("dd@yahoo.com")
                .build();
        return ResponseEntity.ok(studentRepository.save(student));
    }

    @GetMapping("/users")
    public List<Users> usersList(){
        return userService.findAll();
    }
    @GetMapping("/users/{name}")
    public Users findByname(@PathVariable final String name){
        return userService.findByname(name);
    }

    @PostMapping("/users/save")
    public Users saveUsers(@RequestBody Users users){
        Users users1=userService.saveUsers(users);
        return users1;
    }
}
