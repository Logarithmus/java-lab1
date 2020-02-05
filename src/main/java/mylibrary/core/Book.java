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
        return new StringBuilder(10)
            .append("Book {")
            .append("\n    Authors: ").append(Arrays.toString(this.authors))
            .append("\n    Title:   ").append(this.title)
            .append("\n    Year:    ").append(this.year)
            .append("\n    Genre:   ").append(this.genre)
            .append("\n}")
            .toString();
    }

    private boolean equals(Book other) {
        return Arrays.equals(this.authors, other.authors)
            && (this.title == other.title)
            && (this.year == other.year)
            && (this.genre == other.genre);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other instanceof Book) {
            return this.equals((Book) other);
        } else {
            return false;
        }
    }
}