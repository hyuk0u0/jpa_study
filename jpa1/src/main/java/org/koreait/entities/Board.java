package org.koreait.entities;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue
    private Long BoardNo;

    @Column(nullable = false)
    private String BoardSubject;

    @Lob
    @Column(nullable = false)
    private String BoardContent;

    @Column(nullable = false, length = 40)
    private String BoardUserName;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime regDt;

    @Column(insertable = false)
    @UpdateTimestamp
    private LocalDateTime modDt;
}
