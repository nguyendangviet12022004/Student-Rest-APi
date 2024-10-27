package com.viet.studentrestapi.controller;

import com.viet.studentrestapi.entity.Student;
import com.viet.studentrestapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository repo;

    @GetMapping({"/",""})
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        Optional<Student> studentOptional = repo.findById(id);
        return studentOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return ResponseEntity.ok(repo.save(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student){
        Optional<Student> studentOptional = repo.findById(id);
        if(studentOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            repo.save(student);
            return ResponseEntity.ok(student);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id){
        Optional<Student> studentOptional = repo.findById(id);
        if(studentOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            repo.deleteById(id);
            return ResponseEntity.ok(studentOptional.get());
        }
    }
}
