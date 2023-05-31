package org.koreait.jpaexam;

import org.junit.jupiter.api.Test;
import org.koreait.constants.MemberType;
import org.koreait.entities.Member;
import org.koreait.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class JPAExam03 {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void ex01() {
        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("123456");
        member.setUserNm("사용자01");
        member.setMemberType(MemberType.USER);

        member = memberRepository.save(member); // INSERT

        member = memberRepository.findById(member.getUserNo()).orElse(null);
        System.out.println(member);

        member.setUserNm("(수정)사용자01"); // UPDATE
        member = memberRepository.save(member);
        memberRepository.flush();


        member = memberRepository.findById(member.getUserNo()).orElse(null);
        System.out.println(member);

        long count = memberRepository.count();
        System.out.printf("전체 갯수 : %d%n", count);

        memberRepository.delete(member); // 삭제
        memberRepository.flush();

        count = memberRepository.count();
        System.out.printf("전체 갯수 : %d%n", count);
//        memberRepository.flush();

//        Member member2 = memberRepository.saveAndFlush(member);
//        System.out.println(member2);

    }

    private void insertMembers() {
        List<Member> members = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Member member = new Member();
            member.setUserId("user" + i);
            member.setUserPw("123456");
            member.setUserNm("사용자" + i);
            member.setMemberType(MemberType.USER);
            members.add(member);
        }

        memberRepository.saveAllAndFlush(members);

    }

    @Test
    void ex02() {
        insertMembers();
        List<Member> members = memberRepository.findAll();



        members.stream().forEach(System.out::println);
    }

    @Test
    void ex03() {
        insertMembers();
//        Member member = memberRepository.findByUserId("user1");
//        System.out.println(member);
//        List<Member> members = memberRepository.findByUserNmContaining("용");
//        List<Member> members = memberRepository.findByUserNmContainingOrderByRegDtDesc("용");
        List<Member> members = memberRepository.getUsers("용");
        members.stream().forEach(System.out::println);

    }
}
