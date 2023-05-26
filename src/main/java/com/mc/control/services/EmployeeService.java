package com.mc.control.services;

import com.mc.control.models.Employee;
import com.mc.control.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        Optional<Employee> optionalDepartment = employeeRepository.findById(id);
        return optionalDepartment.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Employee with id %d not found", id)));
    }

    @Modifying
    @Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Modifying
    @Transactional
    public void update(Long id, Employee updatedEmployee) {
        updatedEmployee.setId(id);
        employeeRepository.save(updatedEmployee);
    }

    @Modifying
    @Transactional
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

}
