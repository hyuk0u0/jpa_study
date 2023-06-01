package org.koreait.restcontrollers;

import lombok.extern.java.Log;
import org.koreait.constants.MemberType;
import org.koreait.entities.Board;
import org.koreait.entities.Member;
import org.koreait.repositories.BoardRepository;
import org.koreait.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jpa/exam1")
@Log
public class JPAExam1Controller {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/ex01")
    public void ex01() {
        insertData();
    }

    private void insertData() {
        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("123456");
        member.setUserNm("사용자01");
        member.setMemberType(MemberType.USER);

        memberRepository.saveAndFlush(member);

        List<Board> items = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            Board item = new Board();
            item.setBoardSubject("제목" + i);
            item.setBoardContent("내용" + i);
            item.setBoardUserName("작성자" + i);
            item.setMember(member);
            items.add(item);
        }

        boardRepository.saveAllAndFlush(items);
    }

    @GetMapping("/ex02")
    public void ex02() {
        Board board = boardRepository.findById(1L).orElse(null);
//        log.info(board.toString());
        Member member = board.getMember();
        log.info(member.toString());
    }

    @GetMapping("/ex03")
    public void ex03() {
        Member member = memberRepository.findByUserId("user01");
//        List<Board> board = member.getBoards(); // 회원이 작성한 게시글 조회
//        board.stream().forEach(System.out::println);
    }
}
