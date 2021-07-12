package com.dm.demojpa.controllers;

import com.dm.demojpa.entity.Course;
import com.dm.demojpa.entity.CourseMaterial;
import com.dm.demojpa.entity.Student;
import com.dm.demojpa.entity.Teacher;
import com.dm.demojpa.repository.CourseMaterialRepository;
import com.dm.demojpa.repository.CourseRepository;
import com.dm.demojpa.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RestController

public class CourseController {
    @Autowired
    private CourseMaterialRepository repository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/saveTeacher")
    public ResponseEntity saveTeacher(){
        Course course=Course.builder()
                .title("PS")
                .credit(5)
                .build();
        Course courseMBA=Course.builder()
                .title("MBA")
                .credit(78)
                .build();
        Course courseEng=Course.builder()
                .title("Engineer")
                .credit(9)
                .build();
        Teacher teacher=Teacher.builder()
                .firstName("Asif")
                .lastName("karim")
                //.courseList(Arrays.asList(course,courseMBA,courseEng))
                .build();
        return ResponseEntity.ok(teacherRepository.save(teacher));
    }
    @GetMapping("/saveCoursewithTeacherandStudent")
    @Transactional
    public ResponseEntity saveCoursewithTeacherandStudent(){

        Student student=Student.builder()
                .firstName("Dost")
                .lastName("Ali")
                .email("dost@yahoo.com")
                .build();
        Teacher teacher=Teacher.builder()
                .firstName("Ahmed")
                .lastName("Raza")
                .build();

        Course course= Course.builder()
                .title("Mathmatic")
                .credit(4)
                .teacher(teacher)
                .studentList(Arrays.asList(student))

                .build();


        return ResponseEntity.ok(courseRepository.save(course));

    }
@GetMapping("/saveCoursewithTeacher")
    @Transactional
    public ResponseEntity saveCoursewithTeacher(){

        Teacher teacher=Teacher.builder()
                .firstName("Ahmed")
                .lastName("Raza")
                .build();
        Course course= Course.builder()
                .title("Mathmatic")
                .credit(4)
                .teacher(teacher)
                .build();
        CourseMaterial courseMaterial=CourseMaterial.builder()
                .course(course)
                .url("www.google.com")
                .build();
        return ResponseEntity.ok(repository.save(courseMaterial));

    }
    @GetMapping("/saveCourse")
    @Transactional
    public ResponseEntity saveCourse(){

        Course course= Course.builder()
                .title("Mathmatic")
                .credit(4)
                .build();
        CourseMaterial courseMaterial=CourseMaterial.builder()
                .course(course)
                .url("www.google.com")
                .build();
        return ResponseEntity.ok(repository.save(courseMaterial));

    }

    @GetMapping("/findAllCourseMaterials")
    public ResponseEntity findAllCourseMaterials(){
        List<CourseMaterial> courseMaterialList=repository.findAll();
       return ResponseEntity.ok(courseMaterialList);
    }
    @GetMapping("/findAllCourses")
    public ResponseEntity findAllCourses(){
        List<Course> courseList=courseRepository.findAll();
        return ResponseEntity.ok(courseList);

    }
    @GetMapping("/findAllCoursesPaging")
    public ResponseEntity findAllCoursesPaging(){
        Pageable firstPage=PageRequest.of(0,1);
        Pageable secondPage=PageRequest.of(1,3);
        List<Course> courseList=courseRepository.findAll(firstPage).getContent();
        Long totalElement=courseRepository.findAll(firstPage).getTotalElements();
        int totalPages=courseRepository.findAll(firstPage).getTotalPages();
        System.out.println("TotalElement"+totalElement);
        System.out.println("TotalPages"+totalPages);
        return ResponseEntity.ok(courseList);

    }
    @GetMapping("/findAllCoursesPagingWithSorting")
    public ResponseEntity findAllCoursesPagingWithSorting(){
        Pageable sortByTitle=PageRequest.of(0,1,Sort.by("title"));
        Pageable sortByCreditDesc=PageRequest.of(1,3,Sort.by("credit").descending());
        List<Course> courseList=courseRepository.findAll(sortByTitle).getContent();
        List<Course> courseListDes=courseRepository.findAll(sortByCreditDesc).getContent();
        //Repository method containing title
        List<Course> courseListContainingTitle=courseRepository.findByTitleContaining("D",sortByTitle).getContent();


        //Long totalElement=courseRepository.findAll(sortByTitle).getTotalElements();
        //int totalPages=courseRepository.findAll(sortByTitle).getTotalPages();
        //System.out.println("TotalElement"+totalElement);
        //System.out.println("TotalPages"+totalPages);
        return ResponseEntity.ok(courseList);

    }
}
