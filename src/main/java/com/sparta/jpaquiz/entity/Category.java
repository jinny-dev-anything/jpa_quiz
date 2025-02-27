package com.sparta.jpaquiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // TODO 1: 1:N 관계 설정 - 하나의 카테고리는 여러 책(Book)을 가질 수 있습니다.
    // 조건: 카테고리를 저장하는 경우, 연관된 책(Book) 도 함께 저장 되도록 설정
    // 조건: 연관된 책(Book) 엔티티는 실제로 필요할때 DB에서 조회하도록 명시적으로 설정
    // Hint: Cascade 설정을 추가하고 Lazy 로딩 전략을 사용하세요!
    @OneToMany(...)
    private List<Book> books = new ArrayList<>();

    }
