package com.monster.luv_cocktail.domain.repository;

import com.monster.luv_cocktail.domain.entity.CustomCocktail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomCocktailRepository extends JpaRepository<CustomCocktail, String> {
}
