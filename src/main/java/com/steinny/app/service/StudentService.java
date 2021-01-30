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


    public int editStudentById(Long id, Student studentUpdate){
        studentRepository.findById(id);
        return 1;
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
    public Student updateStudentByEmail(String email,String newEmail, String name){
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
        if (studentOptional.isPresent()){
            if (name!=null && name.length()>0 && Objects.equals(studentOptional.get().getName(),name)){
                studentOptional.get().setName(name);
            }
            if (newEmail!=null && newEmail.length()>0 && Objects.equals(studentOptional.get().getEmail(),newEmail)){
                Optional<Student> student = studentRepository.findStudentByEmail(newEmail);
                if (student.isPresent()){
                    String message = "The new email you chose " + newEmail + " already exist";
                    throw new IllegalStateException(message);
                }else {
                    studentOptional.get().setEmail(newEmail);
                }
            }
            return studentOptional.get();
        }else {
            String message = "Student with email " + email +" doesn't exist";
            throw new IllegalStateException(message);
        }
    }
}
