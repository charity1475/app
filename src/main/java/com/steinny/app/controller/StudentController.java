package com.steinny.app.controller;

import com.steinny.app.model.Student;
import com.steinny.app.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @PostMapping(path = "/add",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registerStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

}
