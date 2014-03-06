package bibliophiles.bookstore.service.impl;

import bibliophiles.bookstore.dao.UserDao;
import bibliophiles.bookstore.dao.impl.UserDaoImpl;
import bibliophiles.bookstore.domain.User;
import bibliophiles.bookstore.service.UserService;
import bibliophiles.bookstore.service.exception.UserException;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	public void updateState(String userID, boolean state) {
		// TODO Auto-generated method stub

	}

	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	public User findByCode(String code) {
		return userDao.findByCode(code);
	}

	public void regist(User user) throws UserException {
		User _user = userDao.findByEmail(user.getEmail());
		if (_user != null) {
			throw new UserException("This email address has registed: " + user.getEmail());
		}
		userDao.add(user);
	}

}
