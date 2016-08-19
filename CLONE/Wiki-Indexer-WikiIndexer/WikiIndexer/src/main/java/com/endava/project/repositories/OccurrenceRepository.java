package com.endava.project.repositories;

import com.endava.project.entities.Occurrence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccurrenceRepository extends JpaRepository<Occurrence, Integer> {
}
