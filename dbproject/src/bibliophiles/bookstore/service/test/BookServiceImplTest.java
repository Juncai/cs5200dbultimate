package bibliophiles.bookstore.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bibliophiles.bookstore.domain.Book;
import bibliophiles.bookstore.service.impl.BookServiceImpl;

public class BookServiceImplTest {

	@Test
	public void BookServiceImpleAllTest(){
		BookServiceImpl bookServiceImpl = new BookServiceImpl();
		List<Book> books = new ArrayList<Book>();
		books = bookServiceImpl.all();
		for(Book book: books){
			System.out.println(book);
		}
	}
	
	@Test
	public void BookServiceImpleFindByCategoryTest(){
		BookServiceImpl bookServiceImpl = new BookServiceImpl();
		List<Book> books = new ArrayList<Book>();
		books = bookServiceImpl.findByCategoryID("c1");
		for(Book book: books){
			System.out.println(book);
		}
	}
	
	@Test
	public void BookServiceImpleFindByISBNTest(){
		BookServiceImpl bookServiceImpl = new BookServiceImpl();
		Book book = new Book();
		book = bookServiceImpl.findByIsbn("b1");
			System.out.println(book);
	}
}
