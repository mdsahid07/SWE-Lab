package edu.miu.cs.cs425.sahid.eregistrarwebapi.service.impl;

import edu.miu.cs.cs425.sahid.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.sahid.eregistrarwebapi.repository.StudentRepository;
import edu.miu.cs.cs425.sahid.eregistrarwebapi.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
   public final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(Math.toIntExact(id))
                .or(() -> { throw new RuntimeException("Student not found: " + id); });
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(long id, Student updatedStudent) {
        Optional<Student> existingStudentOpt = getStudentById(id);

        if (existingStudentOpt.isPresent()) {
            Student existingStudent = existingStudentOpt.get(); // Extract the actual Student object

            // Update fields
            existingStudent.setStudentNumber(updatedStudent.getStudentNumber());
            existingStudent.setFirstName(updatedStudent.getFirstName());
            existingStudent.setMiddleName(updatedStudent.getMiddleName());
            existingStudent.setLastName(updatedStudent.getLastName());
            existingStudent.setCgpa(updatedStudent.getCgpa());
            existingStudent.setEnrollmentDate(updatedStudent.getEnrollmentDate());
            existingStudent.setIsInternational(updatedStudent.getIsInternational());

            // Save and return updated student
            return studentRepository.save(existingStudent);
        } else {
            return null; // Or throw a custom exception (recommended)
        }
    }


    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById((int) id);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
