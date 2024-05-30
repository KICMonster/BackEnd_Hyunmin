package com.monster.luv_cocktail.domain.repository;

import com.monster.luv_cocktail.domain.entity.Choice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Long> {
}
