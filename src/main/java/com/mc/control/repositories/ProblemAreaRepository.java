package com.mc.control.repositories;

import com.mc.control.models.ProblemArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemAreaRepository extends JpaRepository<ProblemArea, Long> {
}
