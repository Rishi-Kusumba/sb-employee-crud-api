package dev.projects147.employeecrudapi.service;

import dev.projects147.employeecrudapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String empId);

    String deleteEmployeeById(String empId);
}
