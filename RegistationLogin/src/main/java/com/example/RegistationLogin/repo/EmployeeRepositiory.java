package com.example.RegistationLogin.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.example.RegistationLogin.entity.Employee;

@EnableJpaRepositories
public interface EmployeeRepositiory extends JpaRepository<Employee, Integer> {
  Optional<Employee> findOneByEmailAndPassword(String email, String password);

  Employee findByEmail(String email);
  
  boolean existsByEmail(String email);
  


}


