package bibliophiles.bookstore.admin.service.impl;

import bibliophiles.bookstore.admin.dao.AdministratorDao;
import bibliophiles.bookstore.admin.dao.impl.AdministratorDaoImpl;
import bibliophiles.bookstore.admin.domain.Administrator;
import bibliophiles.bookstore.admin.service.AdministratorService;

public class AdministratorServiceImpl implements AdministratorService {
	private AdministratorDao adminDao = new AdministratorDaoImpl();
	
	public Administrator login(String username, String password) {
		return adminDao.login(username, password);
	}

}
