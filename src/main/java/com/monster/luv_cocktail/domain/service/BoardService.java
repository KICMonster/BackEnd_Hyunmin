package com.monster.luv_cocktail.domain.service;

import com.monster.luv_cocktail.domain.entity.Board;
import com.monster.luv_cocktail.domain.entity.CustomCocktail;
import com.monster.luv_cocktail.domain.repository.BoardRepository;
import com.monster.luv_cocktail.domain.repository.CustomCocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private CustomCocktailRepository customCocktailRepository;

    // 모든 게시판 항목
    public List<Board> findAllBoards() {
        return boardRepository.findAll();
    }

    // ID로 특정 게시판 항목
    public Board findBoardById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    // 게시판 항목을 저장
    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }

    // ID로 특정 게시판 항목을 삭제
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    // 커스텀 칵테일을 포함한 게시판 항목을 생성
    public Board createBoardWithCustomCocktail(Long customCocktailId, Board board) {
        CustomCocktail customCocktail = customCocktailRepository.findById(customCocktailId).orElseThrow(() -> new RuntimeException("Custom Cocktail not found"));
        board.setCustomCocktail(customCocktail);
        return boardRepository.save(board);
    }
}
