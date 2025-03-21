package edu.miu.cs.cs425.sahid.eregistrarwebapi.repository;

import edu.miu.cs.cs425.sahid.eregistrarwebapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
