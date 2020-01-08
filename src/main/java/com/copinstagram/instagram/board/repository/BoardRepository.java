package com.copinstagram.instagram.board.repository;

import com.copinstagram.instagram.board.model.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}