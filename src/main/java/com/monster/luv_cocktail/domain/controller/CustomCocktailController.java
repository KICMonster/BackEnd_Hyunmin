package com.monster.luv_cocktail.domain.controller;

import com.monster.luv_cocktail.domain.entity.CustomCocktail;
import com.monster.luv_cocktail.domain.repository.CustomCocktailRepository;
import com.monster.luv_cocktail.domain.service.CustomCocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customCocktails")
public class CustomCocktailController {

    @Autowired
    private CustomCocktailService customCocktailService;

    @Autowired
    private CustomCocktailRepository customCocktailRepository;  // 추가된 부분

    // 모든 칵테일 조회 (GET /customCocktails)
    @GetMapping
    public List<CustomCocktail> getAllCustomCocktails() {
        return customCocktailService.findAll();
    }

    // 칵테일 이름으로 검색 (GET /customCocktails/search?name=)
    @GetMapping("/search")
    public List<CustomCocktail> searchCustomCocktailsByName(@RequestParam String name) {
        return customCocktailService.findByNameContaining(name);
    }

    // 칵테일 생성 (POST /customCocktails)
    @PostMapping
    public CustomCocktail createCustomCocktail(@RequestBody CustomCocktail customCocktail) {
        return customCocktailService.save(customCocktail);
    }

// 기존 칵테일 수정 (PUT /customCocktails/{id})
    @PutMapping("/{id}")
    public ResponseEntity<CustomCocktail> updateCustomCocktail(@PathVariable Long id, @RequestBody CustomCocktail customCocktail) {
        try {
            CustomCocktail updatedCocktail = customCocktailService.update(id, customCocktail);
            return ResponseEntity.ok(updatedCocktail);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    // 특정 ID로 칵테일 삭제 (DELETE /customCocktails/{id})
    @DeleteMapping("/{id}")
    public void deleteCustomCocktail(@PathVariable Long id) {
        customCocktailService.deleteById(id);
    }
}
