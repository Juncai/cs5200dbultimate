package bibliophiles.bookstore.dao;

import bibliophiles.bookstore.domain.User;
/**
 * 
 * This is the Data Access Object for creating,
 *  referring, updating and deleting the item
 *  in the order 
 *
 * @author Team Bibliophiles
 * 
 */
public interface UserDao {
	
	
	public void add(User user);
	
	
	public User findByEmail(String email);
	
	
	public User findByCode(String code);
	
	
	public void updateState(String userID, boolean state);

}
