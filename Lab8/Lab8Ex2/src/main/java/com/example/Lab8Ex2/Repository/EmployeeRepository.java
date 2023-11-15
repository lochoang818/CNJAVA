package com.example.Lab8Ex2.Repository;

import com.example.Lab8Ex2.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {
}
