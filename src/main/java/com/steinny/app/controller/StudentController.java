package com.steinny.app.controller;

import com.steinny.app.model.Student;
import com.steinny.app.service.StudentService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudentById(@PathVariable("id") String id){
        return studentService.getStudentById(id);
    }
    @PostMapping()
    public HttpStatus registerStudent(@RequestBody @Validated @NonNull Student student){
        studentService.addNewStudent(student);
    }
}
