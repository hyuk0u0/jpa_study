package org.koreait.models.board;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.koreait.entities.Board;
import org.koreait.entities.QBoard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardListService {

    private final EntityManager em;

    public List<Board> gets() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QBoard board = QBoard.board;

        JPAQuery<Board> query = queryFactory.selectFrom(board)
                .leftJoin(board.member)
                .fetchJoin();

        List<Board> items = query.fetch();
        return items;
    }
}
