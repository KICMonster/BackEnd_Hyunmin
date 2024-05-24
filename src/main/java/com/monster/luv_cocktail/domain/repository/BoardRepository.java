package com.monster.luv_cocktail.domain.repository;

import com.monster.luv_cocktail.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
