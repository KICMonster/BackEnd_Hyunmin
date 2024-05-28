package com.monster.luv_cocktail.domain.service;

import com.monster.luv_cocktail.domain.entity.CustomCocktail;
import com.monster.luv_cocktail.domain.repository.CustomCocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomCocktailService {

    @Autowired
    private CustomCocktailRepository customCocktailRepository;

    // 모든 칵테일 조회
    public List<CustomCocktail> findAll() {
        return customCocktailRepository.findAll();
    }

    // 특정 ID로 칵테일 조회
    public CustomCocktail findById(Long id) {
        return customCocktailRepository.findById(id).orElse(null);
    }

    // 칵테일 이름으로 검색
    public List<CustomCocktail> findByNameContaining(String name) {
        return customCocktailRepository.findByNameContaining(name);
    }

    // 재료로 칵테일 검색
    public List<CustomCocktail> findByIngredientContaining(String ingredient) {
        return customCocktailRepository.findByIngredient1ContainingOrIngredient2ContainingOrIngredient3ContainingOrIngredient4Containing(
                ingredient, ingredient, ingredient, ingredient);
    }

    // 칵테일 저장 (생성 및 수정)
    public CustomCocktail save(CustomCocktail customCocktail) {
        return customCocktailRepository.save(customCocktail);
    }

    // 기존 칵테일 수정
    public CustomCocktail update(Long id, CustomCocktail customCocktail) {
        CustomCocktail existingCocktail = customCocktailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Custom Cocktail not found"));
        customCocktail.setId(id);
        return customCocktailRepository.save(customCocktail);
    }

    // 특정 ID로 칵테일 삭제
    public void deleteById(Long id) {
        customCocktailRepository.deleteById(id);
    }
}
