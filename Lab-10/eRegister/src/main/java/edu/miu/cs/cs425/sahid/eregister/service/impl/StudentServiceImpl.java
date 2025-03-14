package edu.miu.cs.cs425.sahid.eregister.service.impl;

import edu.miu.cs.cs425.sahid.eregister.model.Student;
import edu.miu.cs.cs425.sahid.eregister.repository.StudentRepository;
import edu.miu.cs.cs425.sahid.eregister.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Page<Student> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found for ID: " + studentId));
    }

    @Override
    public void updateStudent(long id, Student updatedStudent) {
        Student existingStudent = getStudentById(id);
        existingStudent.setStudentNumber(updatedStudent.getStudentNumber());
        existingStudent.setFirstName(updatedStudent.getFirstName());
        existingStudent.setMiddleName(updatedStudent.getMiddleName());
        existingStudent.setLastName(updatedStudent.getLastName());
        existingStudent.setCgpa(updatedStudent.getCgpa());
        existingStudent.setEnrollmentDate(updatedStudent.getEnrollmentDate());
        existingStudent.setIsInternational(updatedStudent.getIsInternational());
        studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudentById(long studentId) {
        studentRepository.deleteById(studentId);
    }

    // Search method with pagination
    @Override
    public Page<Student> searchStudents(String searchQuery, Pageable pageable) {
        return studentRepository.findByFirstNameContainingOrMiddleNameContainingOrLastNameContainingOrStudentNumberContaining(
                searchQuery, searchQuery, searchQuery, searchQuery, pageable);
    }

    @Override
    public void run(String... args) {
        if (studentRepository.count() == 0) {
            List<Student> students = List.of(
                    new Student("STU001", "John", "A.", "Doe", 3.5, LocalDate.of(2023, 9, 1), "No"),
                    new Student("STU002", "Jane", "B.", "Smith", 3.8, LocalDate.of(2022, 8, 15), "Yes"),
                    new Student("STU003", "Robert", null, "Johnson", 2.9, LocalDate.of(2021, 6, 10), "No"),
                    new Student("STU004", "Alice", "C.", "Williams", 3.2, LocalDate.of(2020, 7, 20), "Yes"),
                    new Student("STU005", "Michael", "D.", "Brown", 3.7, LocalDate.of(2019, 5, 18), "No"),
                    new Student("STU006", "Emily", "E.", "Davis", 3.4, LocalDate.of(2023, 2, 12), "Yes"),
                    new Student("STU007", "Daniel", null, "Martinez", 3.6, LocalDate.of(2022, 11, 22), "No"),
                    new Student("STU008", "Sophia", "F.", "Garcia", 3.9, LocalDate.of(2021, 4, 30), "Yes"),
                    new Student("STU009", "Matthew", "G.", "Anderson", 3.1, LocalDate.of(2020, 9, 14), "No"),
                    new Student("STU010", "Olivia", "H.", "Wilson", 3.3, LocalDate.of(2019, 7, 25), "Yes"),
                    new Student("STU011", "James", null, "Taylor", 3.2, LocalDate.of(2023, 5, 20), "No"),
                    new Student("STU012", "Isabella", "I.", "Thomas", 3.8, LocalDate.of(2022, 6, 15), "Yes"),
                    new Student("STU013", "Benjamin", "J.", "Hernandez", 3.5, LocalDate.of(2021, 8, 10), "No"),
                    new Student("STU014", "Charlotte", null, "Moore", 3.7, LocalDate.of(2020, 3, 5), "Yes"),
                    new Student("STU015", "William", "K.", "Jackson", 3.6, LocalDate.of(2019, 11, 30), "No"),
                    new Student("STU016", "Amelia", "L.", "White", 3.9, LocalDate.of(2023, 7, 22), "Yes"),
                    new Student("STU017", "Ethan", "M.", "Harris", 3.4, LocalDate.of(2022, 2, 18), "No"),
                    new Student("STU018", "Mia", null, "Clark", 3.5, LocalDate.of(2021, 5, 10), "Yes"),
                    new Student("STU019", "Alexander", "N.", "Lewis", 3.3, LocalDate.of(2020, 12, 1), "No"),
                    new Student("STU020", "Harper", "O.", "Walker", 3.7, LocalDate.of(2019, 8, 16), "Yes")
            );
            studentRepository.saveAll(students);
            System.out.println("20 dummy students inserted successfully!");
        }
    }

}
