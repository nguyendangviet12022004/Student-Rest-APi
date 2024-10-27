package com.viet.studentrestapi.repository;

import com.viet.studentrestapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
