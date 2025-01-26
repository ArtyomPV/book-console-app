package ru.study.book_console_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.study.book_console_app.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
