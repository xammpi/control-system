package com.mc.control.repositories;

import com.mc.control.models.Reporter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReporterRepository extends JpaRepository<Reporter,Long> {

    Optional<Reporter> findByUserId(long id);

}
