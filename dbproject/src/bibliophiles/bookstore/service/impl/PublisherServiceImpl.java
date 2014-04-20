package bibliophiles.bookstore.service.impl;

import java.util.List;

import bibliophiles.bookstore.dao.PublisherDao;
import bibliophiles.bookstore.dao.impl.PublisherDaoImpl;
import bibliophiles.bookstore.domain.Publisher;
import bibliophiles.bookstore.service.PublisherService;

public class PublisherServiceImpl implements PublisherService {
	private PublisherDao publisherDao = new PublisherDaoImpl();
	
	public void add(Publisher publisher) {
		publisherDao.add(publisher);
	}

	public void mod(Publisher publisher) {
		publisherDao.update(publisher);
	}

	public void del(String publisherID) {
		publisherDao.del(publisherID);
	}

	public Publisher findByPublisherID(String publisherID) {
		return publisherDao.findByPublisherID(publisherID);
	}

	public List<Publisher> all() {
		return publisherDao.all();
	}

	public Publisher findByName(String name) {
		return publisherDao.findByName(name);
	}

}
