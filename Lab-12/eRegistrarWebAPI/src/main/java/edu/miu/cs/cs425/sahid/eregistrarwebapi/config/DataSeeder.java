package edu.miu.cs.cs425.sahid.eregistrarwebapi.config;

import edu.miu.cs.cs425.sahid.eregistrarwebapi.model.Role;
import edu.miu.cs.cs425.sahid.eregistrarwebapi.model.User;
import edu.miu.cs.cs425.sahid.eregistrarwebapi.repository.RoleRepository;
import edu.miu.cs.cs425.sahid.eregistrarwebapi.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataSeeder {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void seedUsers() {
        if (userRepository.count() == 0) {
            // Ensure roles exist before assigning them to users
            Role adminRole = roleRepository.findByName("ADMIN");
            Role registrarRole = roleRepository.findByName("REGISTRAR");
            Role studentRole = roleRepository.findByName("STUDENT");

            if (adminRole == null) adminRole = roleRepository.save(new Role(null, "ADMIN"));
            if (registrarRole == null) registrarRole = roleRepository.save(new Role(null, "REGISTRAR"));
            if (studentRole == null) studentRole = roleRepository.save(new Role(null, "STUDENT"));

            User admin = new User(null, "ana.admin@eregistrar.com", passwordEncoder.encode("admin123"), Set.of(adminRole));
            User registrar = new User(null, "bob.registrar@eregistrar.com", passwordEncoder.encode("registrar123"), Set.of(registrarRole));
            User student = new User(null, "carlos.student@eregistrar.com", passwordEncoder.encode("student123"), Set.of(studentRole));

            userRepository.save(admin);
            userRepository.save(registrar);
            userRepository.save(student);
        }
    }
}
