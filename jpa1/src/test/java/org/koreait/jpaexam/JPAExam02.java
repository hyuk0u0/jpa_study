package org.koreait.jpaexam;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.koreait.entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@Transactional
public class JPAExam02 {

    @Autowired
    private EntityManager entityManager;

    @Test
    void ex01() {
        Member member = new Member();
        member.setUserId("user01");
        member.setUserNm("사용자01");
        member.setUserPw("123456");

        entityManager.persist(member);
        entityManager.flush();
        System.out.println(member);
    }

}
