package bibliophiles.bookstore.junit.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bibliophiles.bookstore.dao.BookDao;
import bibliophiles.bookstore.dao.impl.BookDaoImpl;
import bibliophiles.bookstore.domain.Book;

public class BookDaoImplTest {
	BookDao dao = new BookDaoImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		BookDao dao = new BookDaoImpl();
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testAll() {
//		BookDao dao = new BookDaoImpl();
		List<Book> list = dao.all();
		for (Book book : list) {
			System.out.println(book.getTitle());
//			for (Author author : book.getAuthors()) {
//				System.out.println(author.getFirstname() + " " + author.getLastname());
//			}
		}
	}

	@Test
	public void testFindByCategoryID() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByIsbn() {
		Book book = dao.findByIsbn("b1");
		System.out.println(book.getTitle());
	}

	@Test
	public void testMod() {
		fail("Not yet implemented");
	}

	@Test
	public void testDel() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByPublisherID() {
		fail("Not yet implemented");
	}

}
