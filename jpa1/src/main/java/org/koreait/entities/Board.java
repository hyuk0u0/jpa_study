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

    @ManyToOne(fetch=FetchType.LAZY) // 지연 로딩
    @JoinColumn(name = "user_no")
    @ToString.Exclude
    private Member member;

}
