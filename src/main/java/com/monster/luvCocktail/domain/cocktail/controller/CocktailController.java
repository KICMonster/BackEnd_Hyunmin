package com.monster.luvCocktail.domain.cocktail.controller;

import com.monster.luvCocktail.domain.cocktail.ApiDefaultSetting;
import com.monster.luvCocktail.domain.cocktail.dto.CocktailDTO;
import com.monster.luvCocktail.domain.cocktail.entity.Cocktail;
import com.monster.luvCocktail.domain.cocktail.service.CocktailService;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cocktail")
@RequiredArgsConstructor
public class CocktailController {

    @Autowired
    private final CocktailService cocktailService;

    @Autowired
    private final ApiDefaultSetting apiDefaultSetting;


    @PostMapping("/save")
    public String saveCocktails(@RequestBody CocktailDTO cocktailDTO) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        List<Cocktail> cocktails = createExampleData(cocktailDTO);

        cocktailService.saveCocktails(cocktails);

        return "저장성공";
    }

    private List<Cocktail> createExampleData(CocktailDTO cocktailDTO) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Cocktail> cocktails = new ArrayList<>();
        JSONObject json = new JSONObject();

        for (int i = 0; i < 600; i++) {
            Cocktail cocktail = cocktailService.getResult(json);    // 작성 완료
            cocktails.add(cocktail);
        }

        return cocktails;
    }


//    @GetMapping("/rawData")
//    private ResponseEntity<JSONArray> getCocktailsList () {
//        StringBuilder url = apiDefaultSetting.getUrlBuilder();
//        String response = apiDefaultSetting.getResult(url);
//        JSONArray obj = apiDefaultSetting.getResultJSON(response);
//        return ResponseEntity.ok(obj);
//    }
    @GetMapping("/rawData")
    private String saveCocktailsList () throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        System.out.println("실행시작");
        StringBuilder url = apiDefaultSetting.getUrlBuilder();
        String response = apiDefaultSetting.getResult(url);
        JSONArray jsonArray = apiDefaultSetting.getResultJSON(response);
        // 칵테일 엔티티 List를 만들고
        List<Cocktail> cocktails = new ArrayList<>();


        // JSONArray를 반복하여 각 JSONObject를 처리
        for (Object obj : jsonArray) {
            JSONObject json = (JSONObject) obj;
            Cocktail cocktail = cocktailService.getResult(json);
            cocktails.add(cocktail);
        }

        cocktailService.saveCocktails(cocktails);
        System.out.println("실행끝");
        return "저장 성공!!!!!!!";
    }
}
