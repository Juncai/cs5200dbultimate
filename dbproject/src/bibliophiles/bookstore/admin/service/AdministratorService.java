package bibliophiles.bookstore.admin.service;

import bibliophiles.bookstore.admin.domain.Administrator;

public interface AdministratorService {
	Administrator login(String username, String password);
}
