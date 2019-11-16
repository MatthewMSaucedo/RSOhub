package com.RSOhub.hub.dao;

import com.RSOhub.hub.model.RsoMembership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RsoMembershipRepository extends JpaRepository<RsoMembership, Integer> {
   List<RsoMembership> findByRefUserId(int refUserId);
}
