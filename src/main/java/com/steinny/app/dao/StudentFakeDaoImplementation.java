package com.steinny.app.dao;

import com.steinny.app.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeDao")
public class StudentFakeDaoImplementation implements StudentDao {

    //private final Map<UUID, Student> database = new HashMap<>();
    private static List<Student> database = new ArrayList<>();
    @Override
    public int insertNewStudent(UUID uuid, Student student) {
        database.add(new Student(uuid, student.getRegNo(),
                student.getAge(),student.getFirstName(),
                student.getLastName(),student.getCourse(),
                 student.getPhone(),student.getEmail()));
        return 1;
    }

    @Override
    public Optional<Student> selectStudentById(UUID uuid) {
        return database.stream().filter(student -> student.getId().equals(uuid))
                .findFirst();
    }

    @Override
    public List<Student> selectAllStudents() {
        return database;
    }

    @Override
    public int updateStudentById(UUID uuid, Student studentUpdate) {
        return selectStudentById(uuid).map(
                student -> {
                    int indexOfPersonToDelete = database.indexOf(student);
                    if(indexOfPersonToDelete>=0){
                        database.set(indexOfPersonToDelete, new Student(uuid, studentUpdate.getRegNo(),
                                student.getAge(),student.getFirstName(),
                                student.getLastName(),student.getCourse(),
                                student.getPhone(),student.getEmail()));
                        return 1;
                    }
                    return 0;
                }
        ).orElse(0);
    }

    @Override
    public int deleteStudentById(UUID uuid) {
        database.remove(uuid);
        return 1;
    }
}
