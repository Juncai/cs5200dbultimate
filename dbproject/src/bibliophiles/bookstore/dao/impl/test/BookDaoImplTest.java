package bibliophiles.bookstore.dao.impl.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bibliophiles.bookstore.dao.impl.BookDaoImpl;
import bibliophiles.bookstore.domain.Book;

public class BookDaoImplTest {

	@Test
	public void BookDaoImplTest1(){
		BookDaoImpl bookDaoImpl = new BookDaoImpl();
		List<Book> books = new ArrayList<Book>();
		books = bookDaoImpl.all();
		for(Book book: books){
			System.out.println(book);
		}
	}
	
	@Test
	public void BookDaoImplTest2(){
		BookDaoImpl bookDaoImpl = new BookDaoImpl();
		List<Book> books = new ArrayList<Book>();
		books = bookDaoImpl.findByCategoryID("c1");
		for(Book book: books){
			System.out.println(book);
		}
	}
}
