package com.global.repository;

import com.global.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
