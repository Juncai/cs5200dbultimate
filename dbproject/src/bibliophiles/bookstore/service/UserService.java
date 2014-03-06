package bibliophiles.bookstore.service;

import bibliophiles.bookstore.domain.User;
import bibliophiles.bookstore.service.exception.UserException;

public interface UserService {
	public void updateState(String userID, boolean state);
	public User findByEmail(String email);
	public User findByCode(String code);
	public void regist(User user) throws UserException;
}
