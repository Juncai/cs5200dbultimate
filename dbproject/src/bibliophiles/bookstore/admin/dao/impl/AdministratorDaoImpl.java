package bibliophiles.bookstore.admin.dao.impl;

import java.sql.SQLException;

import jon.jdbc.utils.JdbcUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import bibliophiles.bookstore.admin.dao.AdministratorDao;
import bibliophiles.bookstore.admin.domain.Administrator;

public class AdministratorDaoImpl implements AdministratorDao {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	
	public Administrator login(String username, String password) {
		String sql = "SELECT * FROM administrator WHERE username=? AND password=?";
		try {
			return qr.query(sql, new BeanHandler<Administrator>(Administrator.class), username, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
