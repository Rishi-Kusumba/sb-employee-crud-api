package dev.projects147.employeecrudapi.controller;

import dev.projects147.employeecrudapi.model.Employee;
import dev.projects147.employeecrudapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(@Qualifier("employeeServiceImpl") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/get")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable("id") String empId) {
        return employeeService.getEmployeeById(empId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable("id") String empId) {
        return employeeService.deleteEmployeeById(empId);
    }

}
