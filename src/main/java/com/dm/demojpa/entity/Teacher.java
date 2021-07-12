package com.dm.demojpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

    @Id
    @SequenceGenerator(name = "teacher_sequence",
    sequenceName = "teacher_sequence",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "teacher_sequence")
    private Long teacher_id;
    private String firstName;
    private String lastName;
//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinColumn(name = "teacher_Id",referencedColumnName = "id")
//    List<Course> courseList;

}
