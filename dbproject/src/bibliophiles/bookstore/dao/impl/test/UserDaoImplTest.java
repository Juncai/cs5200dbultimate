package bibliophiles.bookstore.dao.impl.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bibliophiles.bookstore.dao.impl.UserDaoImpl;
import bibliophiles.bookstore.domain.User;

public class UserDaoImplTest {

	@Test
	public void testFindByEmail() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user = new User();
		user = userDaoImpl.findByEmail("oldfoxes@gmail.com");
		System.out.println(user);
	
	}
}
