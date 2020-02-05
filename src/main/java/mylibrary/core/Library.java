package mylibrary.core;

import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

public class Library {
	public final Map<Book, CatalogEntry> books;
    public final Map<Reader, ReaderEntry> readers;

	public Library() {
		this.books = new HashMap<>();
		this.readers = new HashMap<>();
	}
}
