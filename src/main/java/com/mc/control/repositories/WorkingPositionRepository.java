package com.mc.control.repositories;

import com.mc.control.models.WorkingPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingPositionRepository extends JpaRepository<WorkingPosition, Long> {
}
