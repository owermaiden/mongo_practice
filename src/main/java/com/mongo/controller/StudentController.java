package com.mongo.controller;

import com.mongo.documents.Student;
import com.mongo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = studentService.getAll();
        return ResponseEntity.ok(students);
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student){
        return ResponseEntity.ok(studentService.save(student));
    }

    @GetMapping("/score/{score}")
    public ResponseEntity<List<Student>> getStudentsByScore(@PathVariable("score") int score){
        return ResponseEntity.ok(studentService.getByScore(score));
    }

    @GetMapping("name/{firstName}")
    public ResponseEntity<List<Student>> getStudentsByName(@PathVariable("firstName") String firstName){
        return ResponseEntity.ok(studentService.getBySpringQuery(firstName));
    }

    @GetMapping("lastname/{lastName}")
    public ResponseEntity<List<Student>> getStudentsByLastName(@PathVariable("lastName") String lastName){
        return ResponseEntity.ok(studentService.getBylastName(lastName));
    }
}
