package com.steinny.app.service;

import com.steinny.app.dao.StudentRepository;
import com.steinny.app.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public void addNewStudent(Student student){
        studentRepository.save(student);
    }
    public Optional<Student> getStudentById(Long id){
        return studentRepository.findById(id);
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }


    public int editStudentById(Long id, Student studentUpdate){
        studentRepository.findById(id);
        return 1;
    }
    public void removeStudentById(Long id){
           studentRepository.deleteById(id);
        }
}
