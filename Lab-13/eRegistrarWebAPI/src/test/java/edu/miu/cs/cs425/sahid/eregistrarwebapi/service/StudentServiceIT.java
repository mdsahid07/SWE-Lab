package edu.miu.cs.cs425.sahid.eregistrarwebapi.service;


import static org.junit.jupiter.api.Assertions.*;

import edu.miu.cs.cs425.sahid.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.sahid.eregistrarwebapi.repository.StudentRepository;
import edu.miu.cs.cs425.sahid.eregistrarwebapi.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

@DataJpaTest
public class StudentServiceIT {

    @Autowired
    private StudentRepository studentRepository;

    private StudentService studentService;

    @BeforeEach
    public void setUp() {
        studentService = new StudentServiceImpl(studentRepository);
    }

    @Test
    public void testSaveStudentAndRetrieve() {
        // Given: A new student object
        Student student = new Student();
        student.setStudentNumber("STU001");
        student.setFirstName("Alice");
        student.setMiddleName("Marie");
        student.setLastName("Smith");
        student.setCgpa(3.8);
        student.setEnrollmentDate(LocalDate.of(2023, 9, 1));
        student.setIsInternational("YES");

        // When: The student is saved
        Student savedStudent = studentService.addStudent(student);

        // Then: Verify retrieval from DB
        Optional<Student> foundStudent = studentService.getStudentById(savedStudent.getStudentId());

        assertTrue(foundStudent.isPresent());
        assertEquals("Alice", foundStudent.get().getFirstName());
        assertEquals("Marie", foundStudent.get().getMiddleName());
        assertEquals("Smith", foundStudent.get().getLastName());
        assertEquals("STU001", foundStudent.get().getStudentNumber());
        assertEquals(3.8, foundStudent.get().getCgpa());
        assertEquals(LocalDate.of(2023, 9, 1), foundStudent.get().getEnrollmentDate());
        assertEquals("YES", foundStudent.get().getIsInternational());
    }
}

