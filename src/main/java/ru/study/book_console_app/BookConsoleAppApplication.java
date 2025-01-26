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
public class BookConsoleAppApplication implements CommandLineRunner {
	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookConsoleAppApplication.class, args);
	}
	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Введите '1' для добавления книги, '2' для поиска книги по ID, '3' для вывода всех книг, 'exit' для выхода:");
			String input = scanner.nextLine();

			if ("1".equals(input)) {
				System.out.println("Введите название книги:");
				String title = scanner.nextLine();
				Book book = new Book(title);
				bookRepository.save(book);
				System.out.println("Книга добавлена: " + title);
			} else if ("2".equals(input)) {
				System.out.println("Введите ID книги:");
				Long id = Long.valueOf(scanner.nextLine());
				bookRepository.findById(id).ifPresentOrElse(
						book -> System.out.println("Найдена книга: " + book.getTitle()),
						() -> System.out.println("Книга с ID " + id + " не найдена.")
				);
			} else if ("3".equals(input)) {
				List<Book> books = bookRepository.findAll();
				System.out.println("Все книги:");
				for (Book book : books) {
					System.out.println(book.getId() + ": " + book.getTitle());
				}
			} else if ("exit".equals(input)) {
				break;
			} else {
				System.out.println("Неправильный ввод, попробуйте снова.");
			}
		}

		scanner.close();
	}

}
