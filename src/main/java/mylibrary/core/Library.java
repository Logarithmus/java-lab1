package mylibrary.core;

import java.util.List;
import java.util.ArrayList;

public class Library {
	public final List<CatalogEntry> catalog;
    public final List<ReaderEntry> readers;

	public Library() {
		this.catalog = new ArrayList<>();
		this.readers = new ArrayList<>();
	}
}
