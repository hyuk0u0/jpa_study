package org.koreait.repositories;

import org.koreait.entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>, QuerydslPredicateExecutor<Board> {

    @Query("SELECT b FROM Board b LEFT JOIN FETCH b.member")
    List<Board> getBoards();
}
