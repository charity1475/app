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
import java.util.Optional;
import java.util.UUID;

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
    public Optional<Student> getStudentById(@PathVariable("id") UUID id){
        return studentService.getStudentById(id);
    }
    @PostMapping(path = "/add",consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus registerStudent(@RequestBody @Validated @NonNull Student student){
        studentService.addNewStudent(student.getId(),student);
        return HttpStatus.CREATED;
    }
    @PutMapping(path = "/{id}")
    public void updateStudent(@PathVariable("id") @Validated @NonNull UUID uuid, Student student){
        studentService.editStudentById(uuid, student);
    }
    @DeleteMapping(path = "/{id}")
    public void deleteStudent(@PathVariable("id") UUID uuid){
        studentService.removeStudentById(uuid);
    }
    @GetMapping(path = "/token")
    public UUID getToken(){
        return UUID.randomUUID();
    }
}
