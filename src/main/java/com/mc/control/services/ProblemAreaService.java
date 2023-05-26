package com.mc.control.services;

import com.mc.control.models.ProblemArea;
import com.mc.control.repositories.ProblemAreaRepository;
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
public class ProblemAreaService {

    private final ProblemAreaRepository problemAreaRepository;

    @Autowired
    public ProblemAreaService(ProblemAreaRepository problemAreaRepository) {
        this.problemAreaRepository = problemAreaRepository;
    }

    public List<ProblemArea> findAll() {
        return problemAreaRepository.findAll();
    }

    public ProblemArea findById(Long id) {
        Optional<ProblemArea> optionalProblemArea = problemAreaRepository.findById(id);
        return optionalProblemArea.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Problem are with id %d not found", id)));
    }

    @Modifying
    @Transactional
    public void save(ProblemArea problemArea) {
        problemAreaRepository.save(problemArea);
    }

    @Modifying
    @Transactional
    public void update(Long id, ProblemArea updatedProblemArea) {
        updatedProblemArea.setId(id);
        problemAreaRepository.save(updatedProblemArea);
    }

    @Modifying
    @Transactional
    public void deleteById(Long id) {
        problemAreaRepository.deleteById(id);
    }

}
