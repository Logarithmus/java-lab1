package mylibrary.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ReaderEntry {
    public Reader info;
    private final List<BookHistoryEntry> bookHistory;
    private boolean isBanned;

  	public ReaderEntry(Reader info) {
  		this.info = Objects.requireNonNull(info);
  		this.bookHistory = new ArrayList<>();
  		this.isBanned = false;
  	}

  	public ReaderEntry(String firstName, String lastName) {
  	    this(new Reader(firstName, lastName));
    }

  	@Override
    public String toString() {
        return "ReaderEntry {" +
            "\n    Name: " + this.info +
            "\n    " + this.bookHistory +
            "\n    Banned: " + this.isBanned +
            "\n}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReaderEntry that = (ReaderEntry) o;
        return isBanned == that.isBanned &&
            Objects.equals(info, that.info) &&
            Objects.equals(bookHistory, that.bookHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info, bookHistory, isBanned);
    }

    public Optional<List<BookHistoryEntry>> bookHistory() {
  	    return this.isBanned ? Optional.empty() : Optional.of(this.bookHistory);
    }

    public void ban() {
  	    this.isBanned = true;
    }

    public void unban() {
  	    this.isBanned = false;
    }

    public boolean isBanned() {
  	    return this.isBanned;
    }
}
