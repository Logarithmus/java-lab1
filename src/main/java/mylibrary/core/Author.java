package mylibrary.core;

import java.util.Objects;

public class Author {
    public final String firstName;
    public final String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(firstName, author.firstName) &&
            Objects.equals(lastName, author.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}