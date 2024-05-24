package com.monster.luv_cocktail.domain.controller;

import org.springframework.web.bind.annotation.PostMapping;

public class BoardController {
    @PostMapping("/board/write")
    public String board(String custom_id, String title,String content, String crated_at, String updated_at) {
        System.out.println("커스텀 칵테일 번호: " + custom_id);
        System.out.println("제목: " + title);
        System.out.println("내용: " + content);
        System.out.println("생성일자: " + crated_at);
        System.out.println("수정일자: " + updated_at);

        return "";
    }
}
