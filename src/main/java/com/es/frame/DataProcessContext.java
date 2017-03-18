package com.es.frame;

import java.util.List;

import com.es.frame.BookRecord;

@SuppressWarnings("hiding")
public class DataProcessContext<BookRecord> {

	private List<BookRecord> bookRecords;

	public List<BookRecord> getBookRecords() {
		return bookRecords;
	}

	public void setBookRecords(List<BookRecord> bookRecords) {
		this.bookRecords = bookRecords;
	}
}
