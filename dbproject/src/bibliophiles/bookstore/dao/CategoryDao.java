package bibliophiles.bookstore.dao;

import java.util.List;

import bibliophiles.bookstore.domain.Category;



public interface CategoryDao {
	List<Category> all();
	void add(Category category);
	void mod(Category category);
	int count(String category);
	void del(String category);
	Category findByCategory(String category);
	Category findByCategoryID(String categoryID);
}
