package com.sparta.jpaquiz;

import com.sparta.jpaquiz.entity.Author;
import com.sparta.jpaquiz.entity.Book;
import com.sparta.jpaquiz.entity.Category;
import com.sparta.jpaquiz.repository.AuthorRepository;
import com.sparta.jpaquiz.repository.BookRepository;
import com.sparta.jpaquiz.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibraryService {

    private final CategoryRepository categoryRepository;

    public LibraryService(CategoryRepository categoryRepository, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void addCategoryWithBooks(String categoryName, String bookTitle1, String bookTitle2) {
        // TODO 5: Persistence Context와 @Transactional을 활용해 Category와 Book을 저장합니다.
        // 처리 순서:
        // 1. categoryName 으로 새로운 Category(category1) 를 생성합니다.
        // 2. bookTitle1, bookTitle2 로 새로운 Book(book1, book2) 을 생성합니다.
        // 3. book1, book2을 category1 과 연결합니다. *DB의 외래 키 값을 업데이트하기 위해 Owning 사이드(Book)에 추가
        // 4. category1과 book1, book2 을 연결합니다. *메모리내 객체 상태 동기화를 위해 Non-Owning 사이드(Category)에도 추가
        // 5. category1 저장 *Cascade 설정을 활용해 Category 저장 시 Book도 함께 저장

        // 1. categoryName 으로 새로운 Category(category1) 를 생성합니다.
        Category category = new Category();
        ...

        // 2. bookTitle1, bookTitle2 로 새로운 Book(book1, book2) 을 생성합니다.
        Book book1 = new Book();
        ...

        // 3. book1, book2을 category1 과 연결합니다.
        book1...

        // 4. category1과 book1, book2 을 연결합니다.
        category.getBooks()...

        // 5. category1 저장
        categoryRepository.save(category);
    }
}

