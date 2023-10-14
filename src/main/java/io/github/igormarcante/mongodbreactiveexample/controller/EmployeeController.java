package io.github.igormarcante.mongodbreactiveexample.controller;

import io.github.igormarcante.mongodbreactiveexample.entity.Employee;
import io.github.igormarcante.mongodbreactiveexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAll")
    public ResponseEntity<Flux<Employee>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Mono<Employee>> getById(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Mono<Employee>> save(@RequestBody() Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employee));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Mono<Employee>>update(@RequestBody() Employee employee, @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.update(employee, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Mono<Void>> delete(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(employeeService.delete(id));
    }
}
