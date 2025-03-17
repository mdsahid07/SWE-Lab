package edu.miu.cs.cs425.sahid.eregistrarwebapi.repository;

import edu.miu.cs.cs425.sahid.eregistrarwebapi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
