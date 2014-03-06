package bibliophiles.bookstore.admin.dao;

import bibliophiles.bookstore.admin.domain.Administrator;

public interface AdministratorDao {
	public Administrator login(String username, String password);
}
