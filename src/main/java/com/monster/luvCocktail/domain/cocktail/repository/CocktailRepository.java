package com.monster.luvCocktail.domain.cocktail.repository;

import com.monster.luvCocktail.domain.cocktail.entity.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Long> {
}