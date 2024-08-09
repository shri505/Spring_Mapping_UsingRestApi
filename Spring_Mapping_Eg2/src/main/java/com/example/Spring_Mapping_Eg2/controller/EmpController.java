package com.example.Spring_Mapping_Eg2.controller;

import com.example.Spring_Mapping_Eg2.entity.Emp;
import com.example.Spring_Mapping_Eg2.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/emps")
public class EmpController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping
    public List<Emp> getAllEmps() {
        return employeeRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emp> getEmpById(@PathVariable int id) {
        Optional<Emp> emp = employeeRepo.findById(id);
        return emp.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Emp createEmp(@RequestBody Emp emp) {
        return employeeRepo.save(emp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emp> updateEmp(@PathVariable int id, @RequestBody Emp emp) {
        if (employeeRepo.existsById(id)) {
            emp.setId(id);
            return ResponseEntity.ok(employeeRepo.save(emp));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmp(@PathVariable int id) {
        if (employeeRepo.existsById(id)) {
            employeeRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
