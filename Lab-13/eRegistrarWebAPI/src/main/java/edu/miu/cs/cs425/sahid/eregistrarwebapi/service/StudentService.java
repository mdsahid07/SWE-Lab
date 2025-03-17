package edu.miu.cs.cs425.sahid.eregistrarwebapi.service;

import edu.miu.cs.cs425.sahid.eregistrarwebapi.model.Student;
import org.springframework.boot.CommandLineRunner;

import java.util.List;
import java.util.Optional;

public interface StudentService extends CommandLineRunner {
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    Student addStudent(Student student);
    Student updateStudent(long id,Student student);
    void deleteStudent(long id);
}
