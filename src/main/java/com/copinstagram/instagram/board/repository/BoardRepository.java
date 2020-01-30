package com.copinstagram.instagram.board.repository;

import com.copinstagram.instagram.board.model.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("SELECT p " + "FROM Board p " + "ORDER BY p.id DESC")
    Stream<Board> findAllDesc();
}