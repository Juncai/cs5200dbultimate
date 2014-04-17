package bibliophiles.bookstore.dao;

import java.util.List;

import bibliophiles.bookstore.domain.Category;

/**
 * 
 * This is the Data Access Object for creating,
 *  referring, updating and deleting the category 
 *
 * @author Team Bibliophiles
 * 
 */
public interface CategoryDao {
	
	/**
	 * This method is to look up all the categories
	 * in the database
	 * 
	 * @return all the categories in the database
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */
	List<Category> all();
	
	/**
	 * This method is to add a new category
	 * 
	 * @param category 
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */	
	void add(Category category);
	
	/**
	 * This method is to modify an existed category
	 * 
	 * @param category 
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */	
	void mod(Category category);
	
	/**
	 * This method is to sum up all the records in 
	 * a certain category
	 * 
	 * @param category 
	 * 
	 * @return the number of records in a ceratin 
	 * category
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */	
	int count(String category);
	
	/**
	 * This method is to delete an existed category 
	 * by its ID
	 * 
	 * @param categoryID 
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */	
	void del(String categoryID);
	
	/**
	 * This method is to find an existed category 
	 * by its name
	 * 
	 * @param categoryName 
	 * 
	 * @return the category with a certain name
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors.
	 */	
	Category findByCategory(String categoryName);
	
	/**
	 * This method is to find an existed category 
	 * by its ID
	 * 
	 * @param categoryID
	 * 
	 * @return category with certainID
	 * 
	 * @throws SQLException if there is an exception 
	 * that provides information on a database access
	 * error or other errors. 
	 */
	Category findByCategoryID(String categoryID);
}
