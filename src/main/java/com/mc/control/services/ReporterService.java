package com.mc.control.services;

import com.mc.control.models.Reporter;
import com.mc.control.repositories.ReporterRepository;
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
public class ReporterService {

    private final ReporterRepository reporterRepository;

    @Autowired
    public ReporterService(ReporterRepository reporterRepository) {
        this.reporterRepository = reporterRepository;
    }

    public List<Reporter> findAll() {
        return reporterRepository.findAll();
    }

    public Reporter findById(Long id) {
        Optional<Reporter> optionalReporter = reporterRepository.findById(id);
        return optionalReporter.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Reporter with id %d not found", id)));
    }

    @Modifying
    @Transactional
    public void save(Reporter reporter) {
        reporterRepository.save(reporter);
    }

    @Modifying
    @Transactional
    public void update(Long id, Reporter updatedReporter) {
        updatedReporter.setId(id);
        reporterRepository.save(updatedReporter);
    }

    @Modifying
    @Transactional
    public void deleteById(Long id) {
        reporterRepository.deleteById(id);
    }

}
