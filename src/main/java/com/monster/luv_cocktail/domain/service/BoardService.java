package com.monster.luv_cocktail.domain.service;

import com.monster.luv_cocktail.domain.entity.Board;
import com.monster.luv_cocktail.domain.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }

    public Optional<Board> getBoard(Long id) {
        return boardRepository.findById(id);
    }
}
