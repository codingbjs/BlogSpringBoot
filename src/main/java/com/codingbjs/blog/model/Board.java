package com.codingbjs.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob // 대용량 데이터 필드
    private String content;

    @ColumnDefault("0") // int = "0"  String = "''"  쌍따옴표안에 홑따옴표가 문자로 인식함.
    private int count;

    @ManyToOne(fetch = FetchType.EAGER) // Many=Board, User=One 1명의 User 는 여러개이 게시글을 등록할 수 있다.
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;
}
