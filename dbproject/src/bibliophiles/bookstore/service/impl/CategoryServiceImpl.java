package bibliophiles.bookstore.service.impl;

import java.util.List;

import bibliophiles.bookstore.dao.CategoryDao;
import bibliophiles.bookstore.dao.impl.CategoryDaoImpl;
import bibliophiles.bookstore.domain.Category;
import bibliophiles.bookstore.service.CategoryService;
import bibliophiles.bookstore.service.exception.CategoryException;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDao categoryDao = new CategoryDaoImpl();
	
	public List<Category> all() {
		return categoryDao.all();
	}

	public void add(Category category) throws CategoryException{
		Category _category = categoryDao.findByCategory(category.getCategoryname());
		if (_category != null) {
			throw new CategoryException("The category already exists.");
		}
		categoryDao.add(category);
	}

	public void mod(Category category) {
		categoryDao.mod(category);
	}

	public void del(String categoryID) throws CategoryException{
		int count = categoryDao.count(categoryID);
		if (count > 0) {
			throw new CategoryException("Can't finish deletion. There are books under this category.");
		}
		categoryDao.del(categoryID);
	}

	public Category findByCategoryID(String categoryID) {
		return categoryDao.findByCategoryID(categoryID);
	}

}
