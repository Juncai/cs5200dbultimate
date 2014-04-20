package bibliophiles.bookstore.admin.dao;

import bibliophiles.bookstore.admin.domain.Administrator;
/**
 * 
 * This is the Data Access Object for referring the database.
 * 
 * @author Team Bibliophiles
 * 
 */
public interface AdministratorDao {
	/**
	 * 
	 * This method is check whether the admin with username and
	 * password is in the database.
	 * 
	 * @return 1. certain admin with username and password if found 
	 * in the datebase
	 * <br> 2. null if no such record in the database
	 *  
	 */
	public Administrator login(String username, String password);
}
