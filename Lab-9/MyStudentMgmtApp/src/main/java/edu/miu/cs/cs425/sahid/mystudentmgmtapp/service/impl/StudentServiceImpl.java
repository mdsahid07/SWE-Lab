package edu.miu.cs.cs425.sahid.mystudentmgmtapp.service.impl;

import edu.miu.cs.cs425.sahid.mystudentmgmtapp.model.Course;
import edu.miu.cs.cs425.sahid.mystudentmgmtapp.model.Student;
import edu.miu.cs.cs425.sahid.mystudentmgmtapp.repository.CourseRepository;
import edu.miu.cs.cs425.sahid.mystudentmgmtapp.repository.StudentRepository;
import edu.miu.cs.cs425.sahid.mystudentmgmtapp.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Student registerStudent(Student newStudent, Set<Long> courseIds) {
        if (courseIds != null && !courseIds.isEmpty()) {
            List<Course> courses = courseRepository.findAllByCourseIdIn(courseIds);
            newStudent.getCourses().addAll(courses);
        }
        return studentRepository.save(newStudent) ;
    }

    @Override
    public List<Student> getAllStudents() {
        return List.of();
    }

    @Override
    public Student getStudentById(Integer id) {
        return null;
    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }

    @Override
    public void deleteStudent(Student student) {

    }
}