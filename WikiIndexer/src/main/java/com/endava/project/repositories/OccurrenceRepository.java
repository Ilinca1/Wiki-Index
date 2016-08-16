package com.endava.project.repositories;

import com.endava.project.entities.Occurrence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OccurrenceRepository extends JpaRepository<Occurrence, Integer> {

    @Query("select o from Occurrence o where o.title.id = :id")
    List<Occurrence> findByTitle(@Param(value = "id") Integer id);
}
