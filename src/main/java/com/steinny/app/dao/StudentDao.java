package com.steinny.app.dao;

import com.steinny.app.model.Student;

import java.util.List;

public interface StudentDao {
    int insertNewStudent(String regNo, Student student);
    Student selectStudentById(String regNo);
    List<Student> selectAllStudents();
    int updateStudentById(String regNo, Student studentUpdate);
    int deleteStudentById(String regNo);
}
