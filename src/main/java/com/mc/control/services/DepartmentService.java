package com.mc.control.services;

import com.mc.control.models.Department;
import com.mc.control.repositories.DepartmentRepository;
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
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department findById(Long id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        return optionalDepartment.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Department with id %d not found", id)));
    }

    @Modifying
    @Transactional
    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Modifying
    @Transactional
    public void update(Long id, Department updatedDepartment) {
        updatedDepartment.setId(id);
        departmentRepository.save(updatedDepartment);
    }

    @Modifying
    @Transactional
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }

}
