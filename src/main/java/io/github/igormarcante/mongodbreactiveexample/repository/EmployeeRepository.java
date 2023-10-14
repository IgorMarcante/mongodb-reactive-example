package io.github.igormarcante.mongodbreactiveexample.repository;

import io.github.igormarcante.mongodbreactiveexample.entity.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee,String> {
}
