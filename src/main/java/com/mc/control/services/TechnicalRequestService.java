package com.mc.control.services;

import com.mc.control.models.technical_request.TechnicalRequest;
import com.mc.control.repositories.TechnicalRequestRepository;
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
public class TechnicalRequestService {

    private final TechnicalRequestRepository technicalRequestRepository;

    @Autowired
    public TechnicalRequestService(TechnicalRequestRepository technicalRequestRepository) {
        this.technicalRequestRepository = technicalRequestRepository;
    }

    public List<TechnicalRequest> findAll() {
        return technicalRequestRepository.findAll();
    }

    public TechnicalRequest findById(Long id) {
        Optional<TechnicalRequest> optionalTechnicalRequest = technicalRequestRepository.findById(id);
        return optionalTechnicalRequest.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Technical request with id %d not found", id)));
    }

    @Modifying
    @Transactional
    public void save(TechnicalRequest technicalRequest) {
        technicalRequestRepository.save(technicalRequest);
    }

    @Modifying
    @Transactional
    public void update(Long id, TechnicalRequest updatedTechnicalRequest) {
        updatedTechnicalRequest.setId(id);
        technicalRequestRepository.save(updatedTechnicalRequest);
    }

    @Modifying
    @Transactional
    public void deleteById(Long id) {
        technicalRequestRepository.deleteById(id);
    }

}
