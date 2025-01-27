package ru.study.book_console_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.study.book_console_app.entity.Book;
import ru.study.book_console_app.repository.BookRepository;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BookConsoleAppApplication  {
	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookConsoleAppApplication.class, args);
	}
}
