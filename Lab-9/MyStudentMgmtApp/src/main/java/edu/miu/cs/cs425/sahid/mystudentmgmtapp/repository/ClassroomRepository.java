package edu.miu.cs.cs425.sahid.mystudentmgmtapp.repository;

import edu.miu.cs.cs425.sahid.mystudentmgmtapp.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
}
