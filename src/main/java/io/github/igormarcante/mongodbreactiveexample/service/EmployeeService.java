package io.github.igormarcante.mongodbreactiveexample.service;

import io.github.igormarcante.mongodbreactiveexample.entity.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    public Flux<Employee> getAll();
    public Mono<Employee> getById(String id);
    public Mono<Employee> save(Employee employee);
    public Mono<Employee> update (Employee employee, String id);
    public Mono<Void> delete(String id);
}
