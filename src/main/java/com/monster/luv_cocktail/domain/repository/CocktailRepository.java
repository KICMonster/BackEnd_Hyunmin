package com.monster.luv_cocktail.domain.repository;

import com.monster.luv_cocktail.domain.entity.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CocktailRepository extends JpaRepository<Cocktail, Long> {
    List<Cocktail> findByRecommendIn(List<String> tasteIds);
    
}
