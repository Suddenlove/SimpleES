package com.es.index.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.es.frame.AttrContext;
import com.es.frame.BookRecord;
import com.es.frame.DataProcessContext;
import com.es.index.service.DataProcessServcie;
import com.es.model.Book;
import com.es.model.BookBook;
import com.es.model.BookPress;
import com.es.model.BookSaleAmount;
import com.es.model.BookSaleAttr;
import com.es.model.BookStock;
import com.es.model.Category;

@SuppressWarnings("rawtypes")
public class BookAdditionInfoProcessor implements DataProcessServcie<BookRecord>{
	
	private Map<Long, BookBook> bookMap;
	private Map<Long, BookPress> bookPressMap;
	private Map<Long, BookSaleAmount> bookSaleAmountMap;
	private Map<Long, BookSaleAttr> bookSaleAttrMap;
	private Map<Long, BookStock> bookStockMap;
	private Map<Long, Category> categoryMap;
	
	@SuppressWarnings("unchecked")
	public BookAdditionInfoProcessor(AttrContext context) {
		if(context != null){
			this.bookMap = (Map<Long, BookBook>) context.get("bookMap");
			this.bookPressMap = (Map<Long, BookPress>) context.get("bookPressMap");
			this.bookSaleAmountMap = (Map<Long, BookSaleAmount>) context.get("bookSaleAmountMap");
			this.bookSaleAttrMap = (Map<Long, BookSaleAttr>) context.get("bookSaleAttrMap");
			this.bookStockMap = (Map<Long, BookStock>) context.get("bookStockMap");
			this.categoryMap = (Map<Long, Category>) context.get("categoryMap");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void process(DataProcessContext<BookRecord> processContext) throws Exception {
		List<BookRecord> bookRecords = processContext.getBookRecords();
		List<BookRecord> newRecords = new ArrayList<BookRecord>();
		for(BookRecord bookRecord : bookRecords){
			if(bookRecord.getV() == null){
				continue;
			}
			Long bookId = (Long) bookRecord.getK();
			List<Object> attrs = (List<Object>) bookRecord.getV();
			List<Book> books = joinBook(bookId, attrs);
			if(CollectionUtils.isNotEmpty(books)){
				for(Book book : books){
					if(book == null || bookId == 0){
						continue;
					}
					newRecords.add(new BookRecord<Long, Book>(book.getId(), book));
				}
			}
			processContext.setBookRecords(newRecords);
		}
	}

	private List<Book> joinBook(Long bookId, List<Object> attrs) {
		List<Book> tempBooks = new ArrayList<Book>();
		Book book = null;
		for(Object attr : attrs){
			book = new Book();
			if(attr instanceof BookBook){
				joinBook(book, (BookBook)attr);
			}else if (attr instanceof BookSaleAmount) {
				joinBookSaleAmount(book, (BookSaleAmount)attr);
			}
		}
		return null;
	}

	private void joinBookSaleAmount(Book book, BookSaleAmount attr) {
		
	}

	private void joinBook(Book book, BookBook attr) {
		
	}

	

}
