package com.example.habittracker.repository;

import com.example.habittracker.models.entities.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgressRep extends JpaRepository<Progress, Long> {

    List<Progress> findAllByProfile(Long id);
}
