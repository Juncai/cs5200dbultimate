package bibliophiles.bookstore.dao;

import java.util.List;

import bibliophiles.bookstore.domain.Publisher;
/**
 * @deprecated
 * In this project, we use jsp instead
 * 
 * @author Team Bibliophiles
 */
public interface PublisherDao {
	public void add(Publisher publisher);
	public void update(Publisher publisher);
	public void del(String publisherID);
	public Publisher findByPublisherID(String publisherID);
	public List<Publisher> all();
}
