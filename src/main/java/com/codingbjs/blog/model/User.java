package com.codingbjs.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
//@DynamicInsert // insert 할때 Null 필드는 제외
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;


//    @ColumnDefault("user")
    @Enumerated(EnumType.STRING) // DB 에는 RoleType 이 없어 RoleType 의 저장 타입을 설정
    private RoleType role;

    @CreationTimestamp
    private Timestamp createDate;

}
