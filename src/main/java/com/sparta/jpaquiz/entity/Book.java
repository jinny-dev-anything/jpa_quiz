package com.sparta.jpaquiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // TODO 2: 1:N 관계의 Owning Side 설정 - Book은 하나의 Category에 속합니다.
    // 조건: 카테고리의 외래키 이름은 명시적으로 "category_id_ref"로 설정
    // 조건: 연관된 카테고리(Category)엔티티는 실제로 필요할때 DB에서 조회하도록 명시적으로 설정
    // Hint: ManyToOne 관계를 정의하고 Fetch 전략을 Lazy로 설정하세요.
    @ManyToOne(...)
    private Category category;

    // TODO 3: N:N 관계 설정 - 책(Book)은 여러 저자(Author)와 관련됩니다.
    // 조건: ManyToMany 관계로 설정하여 중간테이블이 자동으로 생성되도록 설정
    // 조건: 책(Book) 저장하는 경우, 연관된 저자(Author) 도 함께 저장 되도록 설정 *HINT:Cascade 설정
    // 조건: 책(Book)쪽에 Owning Side 를 설정
    // 조건: 중간테이블 이름은 명시적으로 "book_author"로 설정
    // 조건: 책/저자의 외래키 이름은 명시적으로 각각 "book_id"/"author_id"로 설정
    @ManyToMany(...)
    private List<Author> authors = new ArrayList<>();

}
