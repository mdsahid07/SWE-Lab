package edu.miu.cs.cs425.sahid.eregister.repository;

import edu.miu.cs.cs425.sahid.eregister.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long>, CrudRepository<Student, Long> {

    // Search method with pagination
    Page<Student> findByFirstNameContainingOrMiddleNameContainingOrLastNameContainingOrStudentNumberContaining(
            String firstName, String middleName, String lastName, String studentNumber, Pageable pageable);
}