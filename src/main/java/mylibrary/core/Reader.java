package mylibrary.core;

import java.util.Objects;

public class Reader {
    public final String firstName;
    public final String lastName;

    public Reader(String firstName, String lastName) {
    	this.firstName = Objects.requireNonNull(firstName);
    	this.lastName = Objects.requireNonNull(lastName);
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reader reader = (Reader) o;
        return Objects.equals(firstName, reader.firstName) &&
            Objects.equals(lastName, reader.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
