package bibliophiles.bookstore.dao;

import bibliophiles.bookstore.domain.User;

public interface UserDao {
	public void add(User user);
	public User findByEmail(String email);
	public User findByCode(String code);
	public void updateState(String userID, boolean state);

}
