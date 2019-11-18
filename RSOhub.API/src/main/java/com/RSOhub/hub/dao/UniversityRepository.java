package com.RSOhub.hub.dao;

import com.RSOhub.hub.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {
    University findByName(String name);
}
