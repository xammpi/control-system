package com.mc.control.services;

import com.mc.control.models.Problem;
import com.mc.control.repositories.ProblemRepository;
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
public class ProblemService {

    private final ProblemRepository problemRepository;

    @Autowired
    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    public List<Problem> findAll() {
        return problemRepository.findAll();
    }

    public Problem findById(Long id) {
        Optional<Problem> optionalProblem = problemRepository.findById(id);
        return optionalProblem.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Problem with id %d not found", id)));
    }

    @Modifying
    @Transactional
    public void save(Problem problem) {
        problemRepository.save(problem);
    }

    @Modifying
    @Transactional
    public void update(Long id, Problem updatedDProblem) {
        updatedDProblem.setId(id);
        problemRepository.save(updatedDProblem);
    }

    @Modifying
    @Transactional
    public void deleteById(Long id) {
        problemRepository.deleteById(id);
    }

}
