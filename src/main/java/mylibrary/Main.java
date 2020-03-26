package mylibrary;

import mylibrary.core.*;
import java.util.regex.Pattern;

final class Main {
	private static final Pattern RUST_PATTERN = Pattern.compile("(?i).*?Rust.*?");

	private static void addReaders(Library lib) {
		lib.readers.add(new ReaderEntry("John", "Smith"));
		lib.readers.add(new ReaderEntry("John", "Carmack"));
		lib.readers.add(new ReaderEntry("Linus", "Torvalds"));
	}

	private static void addBooks(Library lib) {
		lib.catalog.add(
			new CatalogEntry(
				new Book(
					new Author[] {
						new Author("Joanne", "Rowling")
					},
					"Гарри Поттер и Философский Камень",
					1997,
					Genre.FANTASY
				),
				10
			)
		);
		lib.catalog.add(
			new CatalogEntry(
				new Book(
					new Author[] {
						new Author("Steve", "Klabnik"),
						new Author("Carol", "Nichols")
					},
					"The Rust Programming Language",
					2019,
					Genre.COMPUTING
				),
				3
			)
		);
		lib.catalog.add(
			new CatalogEntry(
				new Book(
					new Author[] {
						new Author("Bjarne", "Stroustrup")
					},
					"A Tour of C++ (2nd edition)",
					2018,
					Genre.COMPUTING
				),
				1
			)
		);
	}

	private static void addBorrowedBooks(Library lib) {
		var rustbook = lib.catalog.stream()
			.filter(x -> RUST_PATTERN.matcher(x.book.title).matches())
			.findFirst()
			.orElseThrow();
		rustbook.borrow(1).ifPresentOrElse(
			book -> {
				lib.readers.stream()
					.filter(reader -> reader.info.firstName.equals("Linus"))
					.findFirst()
					.flatMap(reader -> reader.bookHistory())
					.ifPresentOrElse(
						history -> {
							history.add(new BookHistoryEntry(book));
						},
						() -> System.out.println("Oops... The user is banned")
					);
			},
			() -> System.out.println("Oops... Not enough rustbooks")
		);
	}

	private static void returnBorrowedBooks(Library lib) {
		var rustbook = lib.catalog.stream()
			.filter(book -> RUST_PATTERN.matcher(book.book.title).matches())
			.findFirst()
			.orElseThrow();
		if (rustbook.returnBack(1)) {
			var linusHistory = lib.readers.stream()
				.filter(reader -> reader.info.firstName.equals("Linus"))
				.findFirst()
				.flatMap(reader -> reader.bookHistory())
				.orElseThrow();
			linusHistory.stream()
				.filter(entry -> entry.book == rustbook.book)
				.findFirst()
				.ifPresentOrElse(
					entry -> entry.returnBook(),
					() -> System.out.println("Oops... This reader doesn't have this book")
				);
		}

	}

	public static void main(String[] args) throws InterruptedException {
		var lib = new Library();
		addReaders(lib);
		addBooks(lib);
		lib.catalog.forEach(System.out::println);
		lib.readers.forEach(System.out::println);
		addBorrowedBooks(lib);

		System.out.println("-------------------After borrowing-----------------");
		lib.catalog.forEach(System.out::println);
		lib.readers.forEach(System.out::println);

		Thread.sleep(5000);
		returnBorrowedBooks(lib);
		System.out.println("-------------------After returning------------------");
		lib.catalog.forEach(System.out::println);
		lib.readers.forEach(System.out::println);

		Thread.sleep(3000);

	}
}
