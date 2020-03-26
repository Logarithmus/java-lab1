package mylibrary.core;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class BookHistoryEntry {
    public final Book book;
    public final Date dateBorrowed;
    private Optional<Date> dateReturned;

    public BookHistoryEntry(Book book, Date dateBorrowed) {
        this.book = Objects.requireNonNull(book);
        this.dateBorrowed = Objects.requireNonNull(dateBorrowed);
        this.dateReturned = Optional.empty();
    }

    public BookHistoryEntry(Book book) {
        this(book, new Date());
    }

    public Optional<Date> dateReturned() {
        return this.dateReturned;
    }

    public void returnBook() {
        this.dateReturned = Optional.of(new Date());
    }

    @Override
    public String toString() {
        return "BookHistoryEntry {" +
            "\n    Book { " +
            "\n        Authors: " + Arrays.toString(this.book.authors) +
            "\n        Title:   " + this.book.title +
            "\n        Year:    " + this.book.year +
            "\n        Genre:   " + this.book.genre +
            "\n    }" +
            "\n    Date borrowed: " + dateBorrowed +
            "\n    Date returned: " + dateReturned +
            "\n}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BookHistoryEntry that = (BookHistoryEntry) o;
        return Objects.equals(book, that.book) &&
            Objects.equals(dateBorrowed, that.dateBorrowed) &&
            Objects.equals(dateReturned, that.dateReturned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, dateBorrowed, dateReturned);
    }
}
