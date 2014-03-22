package bibliophiles.jdbc.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;

public class JdbcUtils {
	private static DataSource dataSource;
	static {init();}

	private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>();
	

	public static void beginTransaction() throws SQLException {

		Connection con = connectionHolder.get();
		if(con != null) {
			throw new SQLException("Cannot repeatly open a transaction!");
		}

		con = dataSource.getConnection();

		con.setAutoCommit(false);

		connectionHolder.set(con);
	}

	public static void commitTransaction() throws SQLException {
		Connection con = connectionHolder.get();

		if(con == null) {
			throw new SQLException("No transactions can be committed!");
		}
		con.commit();
		con.close();
		connectionHolder.remove();
	}
	
	public static void rollbackTransaction() throws SQLException {
		Connection con = connectionHolder.get();

		if(con == null) {
			throw new SQLException("No transactions to be roll back!");
		}
		con.rollback();
		con.close();
		connectionHolder.remove();
	}

	public static DataSource getDataSource() {
		return dataSource;
	}


	private static void jndi(String jndiName) {
		try {
			Context cxt = new InitialContext();
			dataSource = (DataSource) cxt.lookup("java:/comp/env/" + jndiName);
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}


	private static void initDataSource(Properties prop) {

		String dataSourceClassName = prop.getProperty("dataSourceClassName");
		try {

			Class clazz = Class.forName(dataSourceClassName);

			dataSource = (DataSource) clazz.newInstance();
			BeanUtils.populate(dataSource, prop);
		} catch (Exception e) {
			throw new RuntimeException("Cannot find dataSourceClassName: "
					+ dataSourceClassName, e);
		}
	}


	private static void init() {

		try {

			Properties prop = new Properties();
			InputStream in = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("dbconfig.properties");
			prop.load(in);
			

			String jndiName = prop.getProperty("jndiName");
			

			if(jndiName != null) {
				jndi(jndiName);
				return;
			}
			

			initDataSource(prop);
		} catch (Exception e) {
			throw new RuntimeException("Cannot find dbconfig.properties: ", e);
		}
	}


	public static Connection getConnection() throws SQLException {
		Connection con = connectionHolder.get();
		if(con != null) {
			return con;
		}
		return dataSource.getConnection();
	}

	public static void close(Connection con, Statement stmt) {
		close(con, stmt, null);
	}
	
	public static void close(Connection con) {
		close(con, null, null);
	}

	public static void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
