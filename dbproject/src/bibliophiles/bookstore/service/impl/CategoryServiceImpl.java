package bibliophiles.bookstore.service.impl;

import java.util.List;

import bibliophiles.bookstore.dao.CategoryDao;
import bibliophiles.bookstore.dao.impl.CategoryDaoImpl;
import bibliophiles.bookstore.domain.Category;
import bibliophiles.bookstore.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDao categoryDao = new CategoryDaoImpl();
	
	public List<Category> all() {
		return categoryDao.all();
	}

	public void add(Category category) {
		categoryDao.add(category);
	}

	public void mod(Category category) {
		categoryDao.mod(category);
	}

	public void del(String categoryID) {
		categoryDao.del(categoryID);
	}

	public Category findByCategoryID(String categoryID) {
		return categoryDao.findByCategoryID(categoryID);
	}

}
