package com.dm.demojpa.entity;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString(exclude = "course")

public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "CourseMaterial_sequence",
            sequenceName = "CourseMaterial_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE
    ,generator = "CourseMaterial_sequence")
    private Long courseMaterialId;
    private String url;
    @OneToOne(cascade = CascadeType.ALL
    ,fetch = FetchType.LAZY
    )
    @JoinColumn(name = "course_id",referencedColumnName = "courseId")
    private Course course;
}
