package com.steinny.app.dao;

import com.steinny.app.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("fakeDao")
public class StudentFakeDaoImplementation implements StudentDao {

    private final Map<String, Student> database = new HashMap<>();
    @Override
    public int insertNewStudent(String regNo, Student student) {
        database.put(regNo,student);
        return 1;
    }

    @Override
    public Student selectStudentById(String regNo) {
        return database.get(regNo);
    }

    @Override
    public List<Student> selectAllStudents() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateStudentById(String regNo, Student studentUpdate) {
        database.put(regNo,studentUpdate);
        return 1;
    }

    @Override
    public int deleteStudentById(String regNo) {
        database.remove(regNo);
        return 1;
    }
}
