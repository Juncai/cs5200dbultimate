package bibliophiles.bookstore.service;

import java.util.List;

import bibliophiles.bookstore.domain.Publisher;

public interface PublisherService {
	public void add(Publisher publisher);
	public void mod(Publisher publisher);
	public void del(String publisherID);
	public Publisher findByPublisherID(String publisherID);
	public Publisher findByName(String name);
	public List<Publisher> all();
}
