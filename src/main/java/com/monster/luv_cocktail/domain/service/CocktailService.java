package com.monster.luv_cocktail.domain.service;

import java.util.List;

import com.monster.luv_cocktail.domain.dto.CocktailResponse;

public interface CocktailService {
	// 칵테일 생성하기
//	CocktailResponseDTO create(CocktailRequest request);

	List<CocktailResponse> getList();
	
	CocktailResponse getOne(Long cocktailId);
}