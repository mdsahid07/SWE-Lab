package edu.miu.cs.cs425.sahid.mystudentmgmtapp.repository;

import edu.miu.cs.cs425.sahid.mystudentmgmtapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
