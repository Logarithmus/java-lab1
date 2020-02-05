package mylibrary.core;

import java.util.Objects;

public class Author {
    public final String name;

    public Author(String name) {
    	this.name = Objects.requireNonNull(name);
    }

    @Override
    public String toString() {
        return name;
    }

    private boolean equals(Author other) {
    	return this.name == other.name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other instanceof Author) {
            return this.equals((Author) other);
        } else {
            return false;
        }
    }
}