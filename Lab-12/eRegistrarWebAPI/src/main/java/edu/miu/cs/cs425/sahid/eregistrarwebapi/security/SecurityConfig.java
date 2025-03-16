package edu.miu.cs.cs425.sahid.eregistrarwebapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/eregistrar/api/student/list").hasAnyRole("ADMIN", "REGISTRAR", "STUDENT")
                        .requestMatchers("/eregistrar/api/student/register").hasRole("ADMIN")
                        .requestMatchers("/eregistrar/api/student/get/**").hasAnyRole("ADMIN", "REGISTRAR")
                        .requestMatchers("/eregistrar/api/student/update/**").hasRole("REGISTRAR")
                        .requestMatchers("/eregistrar/api/student/delete/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .httpBasic(withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
