package com.steinny.app.service;

import com.steinny.app.dao.StudentDao;
import com.steinny.app.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int addNewStudent(String regNo, Student student){
        if(studentDao.selectStudentById(regNo) == null){
            studentDao.insertNewStudent(regNo,student);
        }
        return 1;
    }
    public Student getStudentById(String regNo){
        return studentDao.selectStudentById(regNo);
    }
    public List<Student> getAllStudents(){
        return studentDao.selectAllStudents();
    }
    public int editStudentById(String regNo, Student studentUpdate){
        return studentDao.updateStudentById(regNo,studentUpdate);
    }
    public int removeStudentById(String regNo){
        if(studentDao.selectStudentById(regNo)==null){
            return 0;
        }else{
            return studentDao.deleteStudentById(regNo);
        }
    }
}
