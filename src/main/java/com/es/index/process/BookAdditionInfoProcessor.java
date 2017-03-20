package com.es.index.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
public class BookAdditionInfoProcessor implements DataProcessServcie<BookRecord> {

	private Map<Long, BookPress> bookPressMap;
	private Map<Long, BookSaleAttr> bookSaleAttrMap;
	private Map<Long, Category> categoryMap;

	@SuppressWarnings("unchecked")
	public BookAdditionInfoProcessor(AttrContext context) {
		if (context != null) {
			this.bookPressMap = (Map<Long, BookPress>) context.get("bookPressMap");
			this.bookSaleAttrMap = (Map<Long, BookSaleAttr>) context.get("bookSaleAttrMap");
			this.categoryMap = (Map<Long, Category>) context.get("categoryMap");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void process(DataProcessContext<BookRecord> processContext) throws Exception {
		List<BookRecord> bookRecords = processContext.getBookRecords();
		List<BookRecord> newRecords = new ArrayList<BookRecord>();
		for (BookRecord bookRecord : bookRecords) {
			if (bookRecord.getV() == null) {
				continue;
			}
			Long bookId = (Long) bookRecord.getK();
			List<Object> attrs = (List<Object>) bookRecord.getV();
			Book book = joinBook(bookId, attrs);
			if (book != null && book.getId() != 0) {
				newRecords.add(new BookRecord<Long, Book>(book.getId(), book));
			}
		}
		processContext.setBookRecords(newRecords);
	}

	private Book joinBook(Long bookId, List<Object> attrs) {
		Book book = null;
		for (Object attr : attrs) {
			book = new Book();
			if (attr instanceof BookBook) {
				joinBookBook(book, (BookBook) attr);
			} else if (attr instanceof BookSaleAmount) {
				joinBookSaleAmount(book, (BookSaleAmount) attr);
			} else if (attr instanceof BookStock) {
				joinBookStock(book, (BookStock) attr);
			}
		}
		return book;
	}

	private void joinBookStock(Book book, BookStock bookStock) {
		book.setStock(bookStock.getStockAmount());
		book.setStockStatus(bookStock.getStockAmount() > 0 ? 1 : 0);
	}

	private void joinBookSaleAmount(Book book, BookSaleAmount bookSaleAmount) {
		book.setRecentSaleAmount(bookSaleAmount.getRecentAmount());
		book.setTotalSaleAmount(bookSaleAmount.getTotalAmount());
	}

	private void joinBookBook(Book book, BookBook bookBook) {
		book.setId(bookBook.getId());
		book.setPressId(bookBook.getPressId());
		if(bookPressMap != null){
			BookPress bookPress = bookPressMap.get(book.getId());
			book.setPressName(bookPress.getPressName());
		}
		book.setCategoryId(bookBook.getCategoryId());
		if(categoryMap != null){
			Category category = categoryMap.get(book.getId());
			book.setCategoryName(category.getCateName());
		}
		if(bookSaleAttrMap != null){
			List<String> bookSaleAttributes = new ArrayList<String>();
			for(long saleAttrId : book.getSaleAttrIds()){
				String attrName = bookSaleAttrMap.get(saleAttrId).getSaleAttrName();
				if(!bookSaleAttributes.contains(attrName)){
					bookSaleAttributes.add(attrName);
				}
			}
		}
		book.setName(bookBook.getName());
		book.setSubName(bookBook.getSubName());
		book.setAuthor(bookBook.getAuthor());
		book.setRank(bookBook.getRank());
		book.setSellerType(bookBook.getSellerType());
		book.setStatus(bookBook.getStatus());
		book.setOnLineTime(bookBook.getOnLineTime());
		book.setHasEBook(bookBook.getHasEBook());
	}

}
