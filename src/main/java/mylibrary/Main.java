package mylibrary;

import mylibrary.core.*;

class Main {
	public static void main(String[] args) {
		var lib = new Library();
		{
			Author[] authors = {new Author("Дж. К. Роулинг")};
			lib.books.put(
				new Book(
					authors,
					"Гарри Поттер и Философский Камень",
					1997,
					Genre.FANTASY
				),
				new CatalogEntry(10)
			);
		}

		lib.readers.put(new Reader("John", "Smith"), new ReaderEntry());
		lib.readers.put(new Reader("John", "Carmack"), new ReaderEntry());
		lib.readers.put(new Reader("Linus", "Torvalds"), new ReaderEntry());

		lib.books.forEach((book, entry) -> System.out.printf("%s\n%s\n", book, entry));
		System.out.println();
		lib.readers.forEach((reader, entry) -> System.out.printf("%s\n%s\n", reader, entry));
		System.out.println();

		var optLinus = lib.readers.keySet().stream()
			.filter(x -> x.firstName == "Linus")
			.findFirst();
		optLinus.ifPresent(linus -> {
			lib.readers.get(linus).isBanned = true;
			lib.readers.keySet().stream()
				.map(key -> key.equals(linus))
				.forEach(x -> System.out.println(x));
		});

		System.out.println("After ban:");
		lib.readers.forEach((reader, entry) -> System.out.printf("%s\n%s\n", reader, entry));
	}
}
