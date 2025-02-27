package com.sparta.jpaquiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // TODO 4: N:N 관계 설정 - Author는 여러 Book과 관련됩니다.
    // 조건: ManyToMany 관계로 설정하여 중간테이블이 자동으로 생성되도록 설정
    // 조건: 책(Book)쪽에 Owning Side 를 설정
    @ManyToMany(...)
    private List<Book> books = new ArrayList<>();

    }

