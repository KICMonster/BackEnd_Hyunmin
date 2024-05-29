package com.monster.luv_cocktail.domain.controller;

import com.monster.luv_cocktail.domain.entity.Board;
import com.monster.luv_cocktail.domain.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 모든 게시판 항목
    @GetMapping
    public List<Board> getAllBoards() {
        return boardService.findAllBoards();
    }

    // ID로 특정 게시판 항목
    @GetMapping("/{id}")
    public Board getBoardById(@PathVariable Long id) {
        return boardService.findBoardById(id);
    }

    // 커스텀 칵테일을 포함한 게시판 항목을 생성
    @PostMapping("/{customCocktailId}")
    public Board createBoard(@PathVariable Long customCocktailId, @RequestBody Board board) {
        return boardService.createBoardWithCustomCocktail(customCocktailId, board);
    }

    // ID로 특정 게시판 항목을 삭제
    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
    }
}
