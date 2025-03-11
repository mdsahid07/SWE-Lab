package edu.miu.cs.cs425.sahid.mystudentmgmtapp.service.impl;

import edu.miu.cs.cs425.sahid.mystudentmgmtapp.model.Course;
import edu.miu.cs.cs425.sahid.mystudentmgmtapp.repository.CourseRepository;
import edu.miu.cs.cs425.sahid.mystudentmgmtapp.service.CourseService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
    @Override
    public List<Course> saveAll(List<Course> courses) {
        return courseRepository.saveAll(courses);
    }
    @Override
    public List<Course> getAllCourses() {
        return List.of();
    }

    @Override
    public Course updateCourse(Course course) {
        return null;
    }
}
