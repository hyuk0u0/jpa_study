package org.koreait.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.koreait.constants.MemberType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor  // 기본생성자
@AllArgsConstructor
@Table(name="users", indexes = {
        @Index(name="idx_member_userNm", columnList = "userNm")
}) // 테이블 명이 users로 생성
public class Member extends BaseEntity {
    @Id
    //@TableGenerator(name="user_seq")
    //@GeneratedValue(strategy = GenerationType.TABLE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userNo; // 회원번호
    @Column(unique = true, nullable = false, length = 40)
    private String userId; // 회원 아이디
    @Column(name = "userPass", nullable = false, length = 65) // 실제 테이블의 필드명 userPass
    private String userPw; // 회원 비밀번호
    @Column(nullable = false, length = 40)
    private String userNm; // 회원명

    @Lob // String - CLOB
//    @Transient // 엔티티 내부에서만 사용되는 항목 - 테이블 필드로 반영 X
    private String introduction; // 자기소개

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private MemberType memberType;


    @Temporal(TemporalType.DATE) // 날짜
    private Date BirthDt;

    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();
}
