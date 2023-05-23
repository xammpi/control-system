package com.mc.control.services;

import com.mc.control.models.WorkingPosition;
import com.mc.control.repositories.WorkingPositionRepository;
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
public class WorkingPositionService {

    private final WorkingPositionRepository workingPositionRepository;

    @Autowired
    public WorkingPositionService(WorkingPositionRepository workingPositionRepository) {
        this.workingPositionRepository = workingPositionRepository;
    }

    public List<WorkingPosition> findAll() {
        return workingPositionRepository.findAll();
    }

    public WorkingPosition findById(Long id) {
        Optional<WorkingPosition> optionalWorkingPosition = workingPositionRepository.findById(id);
        return optionalWorkingPosition.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Working position with id %d not found", id)));
    }

    @Modifying
    @Transactional
    public void save(WorkingPosition workingPosition) {
        workingPositionRepository.save(workingPosition);
    }

    @Modifying
    @Transactional
    public void update(Long id, WorkingPosition updatedDWorkingPosition) {
        updatedDWorkingPosition.setId(id);
        workingPositionRepository.save(updatedDWorkingPosition);
    }

    @Modifying
    @Transactional
    public void deleteById(Long id) {
        workingPositionRepository.deleteById(id);
    }

}
