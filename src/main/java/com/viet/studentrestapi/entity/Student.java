package com.viet.studentrestapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rollNumber;

    @Column(
            name = "student_name",
            nullable = false
    )
    private String name;

    @Column(
            name = "student_percentage",
            nullable = false
    )
    private double percentage;

    @Column(
            name="student_branch",
            nullable = false
    )
    private String branch;
}
