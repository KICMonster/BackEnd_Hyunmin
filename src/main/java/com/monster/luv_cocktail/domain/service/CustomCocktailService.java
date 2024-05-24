package com.monster.luv_cocktail.domain.service;

import com.monster.luv_cocktail.domain.entity.Board;
import com.monster.luv_cocktail.domain.entity.CustomCocktail;
import com.monster.luv_cocktail.domain.repository.BoardRepository;
import com.monster.luv_cocktail.domain.repository.CustomCocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomCocktailService {
    @Autowired
    private CustomCocktailRepository customCocktailRepository;

    public CustomCocktail saveCustomCocktail(CustomCocktail customCocktail) {
        return customCocktailRepository.save(customCocktail);
    }

    public Optional<CustomCocktail> getCustomCocktail(Long id) {
        return customCocktailRepository.findById(id);
    }
}

