package io.github.igormarcante.mongodbreactiveexample.service.impl;

import io.github.igormarcante.mongodbreactiveexample.entity.Employee;
import io.github.igormarcante.mongodbreactiveexample.repository.EmployeeRepository;
import io.github.igormarcante.mongodbreactiveexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Flux<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Mono<Employee> getById(String id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Mono<Employee> save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Mono<Employee> update(Employee employee, String id) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    @Override
    public Mono<Void> delete(String id) {
        return employeeRepository.deleteById(id);
    }
}
