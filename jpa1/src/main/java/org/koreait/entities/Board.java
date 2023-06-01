package org.koreait.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board extends BaseEntity {
    @Id
    @GeneratedValue
    private Long boardNo;

    @Column(nullable = false)
    private String boardSubject;

    @Lob
    @Column(nullable = false)
    private String boardContent;

    @Column(nullable = false, length = 40)
    private String boardUserName;

    @ManyToOne(fetch=FetchType.LAZY) // 지연 로딩(LAZY) - Global 전략, 필요할때만 즉시 로딩(EAGER)
    @JoinColumn(name = "user_no")
    @ToString.Exclude
    private Member member;

}
