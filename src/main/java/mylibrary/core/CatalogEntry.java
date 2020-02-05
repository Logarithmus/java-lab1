package mylibrary.core;

import java.util.Objects;

public class CatalogEntry {
	private int onHandCount;
	private int totalCount;

	public CatalogEntry(int count) {
		this.onHandCount = count;
		this.totalCount = count;
	}

	@Override
    public String toString() {
        return new StringBuilder(6)
            .append("CatalogEntry {")
            .append("\n    On hand:     ").append(this.onHandCount)
            .append("\n    Total count: ").append(this.totalCount)
            .append("\n}")
            .toString();
    }

    private boolean equals(CatalogEntry other) {
    	return (this.onHandCount() == other.onHandCount())
    		&& (this.totalCount() == other.totalCount());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other instanceof CatalogEntry) {
            return this.equals((CatalogEntry) other);
        } else {
            return false;
        }
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

	public boolean borrow(int count) {
		boolean f = count <= this.onHandCount;
		if (f) {
			this.onHandCount -= count;
		}
		return f;
	}

	public boolean giveBack(int count) {
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