package dev.projects147.employeecrudapi.service;

import dev.projects147.employeecrudapi.customexception.EmployeeNotFoundException;
import dev.projects147.employeecrudapi.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee addEmployee(Employee employee) {
        if (employee.getId() == null || employee.getId().isEmpty())
            employee.setId(UUID.randomUUID().toString());
        employeeList.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String empId) {
        Employee employee = employeeList.stream()
                .filter(emp -> emp.getId().equals(empId))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with Id : " + empId));
        return employee;
    }

    @Override
    public String deleteEmployeeById(String empId) {
        Optional<Employee> optionalEmployee = employeeList.stream()
                .filter(emp -> emp.getId().equals(empId))
                .findFirst();
        if (optionalEmployee.isPresent()) {
            employeeList.remove(optionalEmployee.get());
            return "Employee deleted with Id : " + empId;
        } else
            throw new EmployeeNotFoundException("Employee not found with Id : " + empId);
    }
}
