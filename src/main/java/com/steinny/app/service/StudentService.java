package com.steinny.app.service;

import com.steinny.app.dao.StudentRepository;
import com.steinny.app.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public void addNewStudent(Student student){
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            String message = "Student with email " + student.getEmail() +" already exists";
            throw new IllegalStateException(message);
        }else {
            studentRepository.save(student);
        }
    }
    public Optional<Student> getStudentByEmail(String email){
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
        if (!studentOptional.isPresent()){
            String message = "Student with email " + email +" doesn't exist";
            throw new IllegalStateException(message);
        }else {
            return studentRepository.findStudentByEmail(email);
        }
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }


    public void removeStudentByEmail(String email){
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
        if (studentOptional.isPresent()){
            studentRepository.deleteById(studentOptional.get().getId());
        }else {
            String message = "Student with email " + email +" doesn't exist";
            throw new IllegalStateException(message);
        }
    }

    @Transactional
    public void updateStudent(Long id,String name,String email){
        Student student = studentRepository.findById(id).orElseThrow(()-> new IllegalStateException("Student with Id " + id +" doesn't exist"));

            if (name!=null && name.length()>0){
                student.setName(name);
                studentRepository.save(student);
            }
            if (email!=null && email.length()>0){
                Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
                if (studentOptional.isPresent()){
                    String message = "The new email you chose " + email + " already exist";
                    throw new IllegalStateException(message);
                }else {
                    student.setEmail(email);
                    studentRepository.save(student);
                }
            }
    }
}
