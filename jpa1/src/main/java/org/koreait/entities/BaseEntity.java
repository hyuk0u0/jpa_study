package org.koreait.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Column(updatable = false) // 수정 불가
//    @CreationTimestamp // INSERT 쿼리시 자동으로 현재 날짜와 시간이 추가
    @CreatedDate
    private LocalDateTime regDt; // 회원 가입일시

    @Column(insertable = false) // 추가 불가
//    @UpdateTimestamp  // UPDATE 쿼리시 자동으로 현재 날짜와 시간이 수정
    @LastModifiedDate
    private LocalDateTime modDt; // 회원 정보 수정일시
}
