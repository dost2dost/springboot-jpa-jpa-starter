package com.dm.demojpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    @SequenceGenerator(name = "Course_Sequence",sequenceName = "Course_Sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Course_Sequence")
    private Long courseId;
    private String title;
    private Integer credit;
    @OneToOne(
            mappedBy = "course",
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private CourseMaterial courseMaterial;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacherID",referencedColumnName = "teacher_id")
    private Teacher teacher;
    // many to many relation ship need join table and invers join columns
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Student_Course",joinColumns =@JoinColumn(name = "course_ID",referencedColumnName = "courseId"),
    inverseJoinColumns = @JoinColumn(name = "student_id",referencedColumnName = "studentId"))
    List<Student> studentList;

    public void addStudent(Student student){
        if(studentList ==null) studentList=new ArrayList<>();
        studentList.add(student);
    }
}
