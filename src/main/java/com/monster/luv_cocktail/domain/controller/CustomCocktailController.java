package com.monster.luv_cocktail.domain.controller;

import com.monster.luv_cocktail.domain.entity.Board;
import com.monster.luv_cocktail.domain.entity.CustomCocktail;
import com.monster.luv_cocktail.domain.service.BoardService;
import com.monster.luv_cocktail.domain.service.CustomCocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/custom-cocktails")
public class CustomCocktailController {
    @Autowired
    private CustomCocktailService customCocktailService;

    @PostMapping
    public ResponseEntity<CustomCocktail> createCustomCocktail(@RequestBody CustomCocktail customCocktail) {
        CustomCocktail savedCustomCocktail = customCocktailService.saveCustomCocktail(customCocktail);
        return ResponseEntity.ok(savedCustomCocktail);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomCocktail> getCustomCocktail(@PathVariable Long id) {
        Optional<CustomCocktail> customCocktail = customCocktailService.getCustomCocktail(id);
        return customCocktail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}