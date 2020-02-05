package mylibrary.core;

import java.util.Objects;

public class ReaderEntry {
    public boolean isBanned;

  	public ReaderEntry() {
  		this.isBanned = false;
  	}

  	@Override
    public String toString() {
        return new StringBuilder(4)
            .append("ReaderEntry {")
            .append("\n    Banned: ").append(this.isBanned)
            .append("\n}")
            .toString();
    }

    private boolean equals(ReaderEntry other) {
    	return this.isBanned == other.isBanned;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other instanceof ReaderEntry) {
            return this.equals((ReaderEntry) other);
        } else {
            return false;
        }
    }
}
