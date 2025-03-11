package edu.miu.cs.cs425.sahid.mystudentmgmtapp.service;

import edu.miu.cs.cs425.sahid.mystudentmgmtapp.model.Student;

import java.util.List;
import java.util.Set;

public interface StudentService {
    Student registerStudent(Student student, Set<Long> courseIds);
    List<Student> getAllStudents();
    Student getStudentById(Integer id);
    Student updateStudent(Student student);
    void deleteStudent(Student student);
}
