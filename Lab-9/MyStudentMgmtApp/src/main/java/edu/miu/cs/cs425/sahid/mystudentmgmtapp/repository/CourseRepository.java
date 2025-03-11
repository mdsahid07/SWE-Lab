package edu.miu.cs.cs425.sahid.mystudentmgmtapp.repository;

import edu.miu.cs.cs425.sahid.mystudentmgmtapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findAllByCourseIdIn(Set<Long> courseIds);
}
