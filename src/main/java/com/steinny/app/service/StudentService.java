package com.steinny.app.service;

import com.steinny.app.dao.StudentDao;
import com.steinny.app.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("fakeDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int addNewStudent(UUID uuid, Student student){
        studentDao.insertNewStudent(uuid,student);
        return 1;
    }
    public Optional<Student> getStudentById(UUID uuid){
        return studentDao.selectStudentById(uuid);
    }
    public List<Student> getAllStudents(){
        return studentDao.selectAllStudents();
    }
    public int editStudentById(UUID uuid, Student studentUpdate){
        return studentDao.updateStudentById(uuid,studentUpdate);
    }
    public int removeStudentById(UUID uuid){
            return studentDao.deleteStudentById(uuid);
        }
}
