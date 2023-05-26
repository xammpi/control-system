package com.mc.control.repositories;

import com.mc.control.models.technical_request.TechnicalRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalRequestRepository extends JpaRepository<TechnicalRequest, Long> {
}
