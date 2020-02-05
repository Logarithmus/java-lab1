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
        return new StringBuilder(6)
            .append("Reader {")
            .append("\n    First name: ").append(this.firstName)
            .append("\n    Last name:  ").append(this.lastName)
            .append("\n}")
            .toString();
    }

    private boolean equals(Reader other) {
    	return (this.firstName == other.firstName)
    		&& (this.lastName == other.lastName);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other instanceof Reader) {
            return this.equals((Reader) other);
        } else {
            return false;
        }
    }
}
