package com.endava.project.repositories;

import com.endava.project.entities.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository used for managing all the CRUD operations with the database -> for Title
 */
@Repository
public interface TitleRepository extends JpaRepository<Title, Integer> {

    Title findByName(String name);
}
