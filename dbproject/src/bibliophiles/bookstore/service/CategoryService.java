package bibliophiles.bookstore.service;

import java.util.List;

import bibliophiles.bookstore.domain.Category;
import bibliophiles.bookstore.service.exception.CategoryException;

public interface CategoryService {
	List<Category> all();
	void add(Category category) throws CategoryException;
	void mod(Category category);
	void del(String categoryID) throws CategoryException;
	Category findByCategoryID(String categoryID);
}
