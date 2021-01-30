package com.steinny.app.controller;

import com.steinny.app.model.Student;
import com.steinny.app.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping(path = "/{email}")
    public Optional<Student> getStudentByEmail(@PathVariable String email){
        return studentService.getStudentByEmail(email);
    }
    @DeleteMapping(path = "/{email}")
    public void deleteByEmail(@PathVariable String email){
        studentService.removeStudentByEmail(email);
    }

    @PutMapping(path = "update/{id}")
    public void updateByEmail(@PathVariable("id") Long id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentService.updateStudentByEmail(id,name,email);
    }

}
