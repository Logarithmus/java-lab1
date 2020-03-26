package mylibrary.core;

import java.util.Objects;
import java.util.Arrays;

public class Book {
    public final Author[] authors;
    public final String title;
    public final int year;
    public final Genre genre;

    public Book(Author[] authors, String title, int year, Genre genre) {
    	this.authors = Objects.requireNonNull(authors);
    	this.title = Objects.requireNonNull(title);
    	this.year = year;
    	this.genre = Objects.requireNonNull(genre);
    }

    @Override
    public String toString() {
        return "Book {" +
            "\n    Authors: " + Arrays.toString(this.authors) +
            "\n    Title:   " + this.title +
            "\n    Year:    " + this.year +
            "\n    Genre:   " + this.genre +
            "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
            Arrays.equals(authors, book.authors) &&
            Objects.equals(title, book.title) &&
            genre == book.genre;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(title, year, genre);
        return 31 * result + Arrays.hashCode(authors);
    }
}