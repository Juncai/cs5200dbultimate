package bibliophiles.bookstore.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import bibliophiles.bookstore.dao.CategoryDao;
import bibliophiles.bookstore.domain.Category;
import bibliophiles.jdbc.utils.JdbcUtils;

public class CategoryDaoImpl implements CategoryDao {
	QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	
	public List<Category> all() {
		String sql = "SELECT * FROM category";
		try {
			return qr.query(sql, new BeanListHandler<Category>(Category.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void add(Category category) {
		String sql = "INSERT INTO category VALUES(?,?)";
		try {
			qr.update(sql, category.getCategoryID(), category.getCategoryname());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void mod(Category category) {
		String sql = "UPDATE category SET categoryname=? WHERE categoryID=?";
		try {
			qr.update(sql, category.getCategoryname(), category.getCategoryID());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int count(String categoryID) {
		String sql = "SELECT COUNT(isbn) FROM book WHERE categoryID=?";
		try {
			Number count = (Number)qr.query(sql, new ScalarHandler(), categoryID);
			return count.intValue();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void del(String categoryID) {
		String sql = "DELETE FROM category WHERE categoryID=?";
		try {
			qr.update(sql, categoryID);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Category findByCategory(String category) {
		String sql = "SELECT * FROM category WHERE categoryname=?";
		try {
			return qr.query(sql, new BeanHandler<Category>(Category.class), category);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Category findByCategoryID(String categoryID) {
		String sql = "SELECT * FROM category WHERE categoryID=?";
		try {
			return qr.query(sql, new BeanHandler<Category>(Category.class), categoryID);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
