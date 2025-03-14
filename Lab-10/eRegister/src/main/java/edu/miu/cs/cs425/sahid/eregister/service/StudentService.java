package edu.miu.cs.cs425.sahid.eregister.service;

import edu.miu.cs.cs425.sahid.eregister.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService extends CommandLineRunner {

    public abstract Page<Student> getAllStudents(Pageable pageable);

    public abstract Student saveStudent(Student student);
    public abstract Student getStudentById(long studentId);
    public abstract void updateStudent(long id, Student student);
    public abstract void deleteStudentById(long studentId);
    public abstract Page<Student> searchStudents(String searchString, Pageable pageable);
    public abstract void run(String... args);
}
