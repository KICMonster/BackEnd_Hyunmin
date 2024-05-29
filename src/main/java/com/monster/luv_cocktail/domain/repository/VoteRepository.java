package com.monster.luv_cocktail.domain.repository;

import com.monster.luv_cocktail.domain.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
}
