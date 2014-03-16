package bibliophiles.bookstore.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import bibliophiles.bookstore.dao.UserDao;
import bibliophiles.bookstore.domain.User;
import bibliophiles.jdbc.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	
	public void add(User user) {
		String sql = "INSERT INTO user (userID,email,password,lastname,firstname,middlename,"
				+ "gender,cellphone,code,state) VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			qr.update(sql, user.getUserID(), user.getEmail(), user.getPassword(),
					user.getLastname(), user.getFirstname(), user.getMiddlename(),
					user.getGender(), user.getCellphone(), user.getCode(),
					user.isState());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public User findByEmail(String email) {
		String sql = "SELECT * FROM user WHERE email=?";
		try {
			return qr.query(sql, new BeanHandler<User>(User.class), email);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public User findByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateState(String userID, boolean state) {
		// TODO Auto-generated method stub

	}

}
