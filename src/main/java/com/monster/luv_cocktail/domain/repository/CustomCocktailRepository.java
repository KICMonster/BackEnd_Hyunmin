package com.monster.luv_cocktail.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.monster.luv_cocktail.domain.entity.CustomCocktail;

public interface CustomCocktailRepository extends JpaRepository<CustomCocktail, Long> {
    List<CustomCocktail> findByNameContaining(String name);
    List<CustomCocktail> findByIngredient1ContainingOrIngredient2ContainingOrIngredient3ContainingOrIngredient4Containing(
            String ingredient1, String ingredient2, String ingredient3, String ingredient4);
}
