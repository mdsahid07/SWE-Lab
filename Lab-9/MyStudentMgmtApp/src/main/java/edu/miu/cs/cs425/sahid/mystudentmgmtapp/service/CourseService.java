package edu.miu.cs.cs425.sahid.mystudentmgmtapp.service;

import edu.miu.cs.cs425.sahid.mystudentmgmtapp.model.Course;

import java.util.List;

public interface CourseService {
    Course saveCourse(Course course);
    List<Course> saveAll(List<Course> courses);
    List<Course> getAllCourses();
    Course updateCourse(Course course);
}
