package edu.miu.cs.cs425.sahid.eregistrarwebapi.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import edu.miu.cs.cs425.sahid.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.sahid.eregistrarwebapi.repository.StudentRepository;
import edu.miu.cs.cs425.sahid.eregistrarwebapi.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    private Student student;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Creating a student object based on your model
        student = new Student();
        student.setStudentId(1L);
        student.setStudentNumber("STU001");
        student.setFirstName("John");
        student.setMiddleName("Michael");
        student.setLastName("Doe");
        student.setCgpa(3.5);
        student.setEnrollmentDate(LocalDate.of(2023, 9, 1));
        student.setIsInternational("NO");
    }

    @Test
    public void testGetStudentById_ExistingStudent() {
        when(studentRepository.findById(1)).thenReturn(Optional.of(student));

        Optional<Student> foundStudent = studentService.getStudentById(1L);

        assertTrue(foundStudent.isPresent());
        assertEquals("John", foundStudent.get().getFirstName());
        assertEquals("Michael", foundStudent.get().getMiddleName());
        assertEquals("Doe", foundStudent.get().getLastName());
        assertEquals("STU001", foundStudent.get().getStudentNumber());
        assertEquals(3.5, foundStudent.get().getCgpa());
        assertEquals(LocalDate.of(2023, 9, 1), foundStudent.get().getEnrollmentDate());
        assertEquals("NO", foundStudent.get().getIsInternational());

        verify(studentRepository, times(1)).findById(1);
    }

    @Test
    void testGetStudentById_NonExistingStudent() {
        long nonExistingStudentId = 2;

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            studentService.getStudentById(nonExistingStudentId);
        });

        assertEquals("Student not found: 2", exception.getMessage());
    }
}


