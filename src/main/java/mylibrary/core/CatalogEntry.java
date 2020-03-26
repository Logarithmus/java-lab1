package mylibrary.core;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class CatalogEntry {
	public final Book book;
	private int onHandCount;
	private int totalCount;

	public CatalogEntry(Book book, int count) {
		this.book = Objects.requireNonNull(book);
		this.onHandCount = count;
		this.totalCount = count;
	}

	@Override
    public String toString() {
        return "CatalogEntry {" +
			"\n    Book {" +
			"\n        Authors: " + Arrays.toString(this.book.authors) +
			"\n        Title:   " + this.book.title +
			"\n        Year:    " + this.book.year +
			"\n        Genre:   " + this.book.genre +
			"\n    }" +
			"\n    On hand:     " + this.onHandCount +
			"\n    Total count: " + this.totalCount +
			"\n}\n";
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CatalogEntry that = (CatalogEntry) o;
		return onHandCount == that.onHandCount &&
			totalCount == that.totalCount &&
			Objects.equals(book, that.book);
	}

	@Override
	public int hashCode() {
		return Objects.hash(book, onHandCount, totalCount);
	}

	public void add(int count) {
		this.onHandCount += count;
		this.totalCount += count;
	}

	public boolean remove(int count) {
		boolean f = count <= this.totalCount;
		if (f) {
			this.onHandCount -= count;
			this.totalCount -= count;
		}
		return f;
	}

	public Optional<Book> borrow(int count) {
		boolean f = count <= this.onHandCount;
		if (f) {
			this.onHandCount -= count;
		}
		return f ? Optional.of(this.book) : Optional.empty();
	}

	public boolean returnBack(int count) {
		boolean f = (this.onHandCount + count) <= this.totalCount;
		if (f) {
			this.onHandCount += count;
		}
		return f;
	}

	public int onHandCount() {
		return this.onHandCount;
	}

	public int totalCount() {
		return this.totalCount;
	}
}