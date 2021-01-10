package com.steinny.app.dao;

import com.steinny.app.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentDao {
    int insertNewStudent(UUID uuid, Student student);
    default int insertNewStudent(Student student){
        UUID uuid = UUID.randomUUID();
        return insertNewStudent(uuid,student);
    }
    Optional<Student> selectStudentById(UUID uuid);
    List<Student> selectAllStudents();
    int updateStudentById(UUID uuid, Student studentUpdate);
    int deleteStudentById(UUID uuid);
}
