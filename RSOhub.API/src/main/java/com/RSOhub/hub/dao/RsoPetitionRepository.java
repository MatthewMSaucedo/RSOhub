package com.RSOhub.hub.dao;

import com.RSOhub.hub.model.RsoPetition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RsoPetitionRepository extends JpaRepository<RsoPetition, Integer> {
    RsoPetition findByRefRsoId(int refRsoId);
}
