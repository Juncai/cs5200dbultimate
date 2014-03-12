package bibliophiles.bookstore.service;

import java.util.List;

import bibliophiles.bookstore.domain.Category;

public interface CategoryService {
	List<Category> all();
	void add(Category category);
	void mod(Category category);
	void del(String categoryID);
	Category findByCategoryID(String categoryID);
}
