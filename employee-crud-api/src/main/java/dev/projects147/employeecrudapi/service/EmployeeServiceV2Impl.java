package dev.projects147.employeecrudapi.service;

import dev.projects147.employeecrudapi.customexception.EmployeeNotFoundException;
import dev.projects147.employeecrudapi.entity.EmployeeEntity;
import dev.projects147.employeecrudapi.model.Employee;
import dev.projects147.employeecrudapi.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceV2Impl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        if (employee.getId() == null || employee.getId().isEmpty())
            employee.setId(UUID.randomUUID().toString());
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
        List<Employee> employeeList = employeeEntityList.stream()
                .map(employeeEntity -> {
                    Employee employee = new Employee();
                    BeanUtils.copyProperties(employeeEntity, employee);
                    return employee;
                })
                .collect(Collectors.toList());
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String empId) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(empId);
        if (employeeEntity.isPresent()) {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeEntity.get(), employee);
            return employee;
        } else throw new EmployeeNotFoundException("Employee not found with Id : " + empId);
    }

    @Override
    public String deleteEmployeeById(String empId) {
        if (employeeRepository.existsById(empId)) {
            employeeRepository.deleteById(empId);
            return "Employee deleted with Id : " + empId;
        } else
            throw new EmployeeNotFoundException("Employee not found with Id : " + empId);
    }
}
