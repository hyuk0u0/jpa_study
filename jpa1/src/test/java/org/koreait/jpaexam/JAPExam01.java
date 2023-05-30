package org.koreait.jpaexam;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.koreait.entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
@Transactional
public class JAPExam01 {

    @Autowired
    private EntityManager em;

    @Test
    void ex01() {
        Member member = new Member();
        member.setUserNo(1L);
        member.setUserId("user01");
        member.setUserNm("사용자01");
        member.setUserPw("123456");

        em.persist(member); // 영속성 상태 변화 감지
        em.flush(); // 변화 상태 -> DB에 반영

        member.setUserNm("(수정)사용자01"); // 수정

        em.flush(); // 변화 상태 -> DB에 반영
    }
}
