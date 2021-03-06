package bibliophiles.bookstore.dao;

import java.util.List;

import bibliophiles.bookstore.domain.Publisher;
/**
 * This is the Data Access Object for creating,
 *  referring, updating and deleting the database 
 * 
 * @author Team Bibliophiles
 */
public interface PublisherDao {
	public void add(Publisher publisher);
	public void update(Publisher publisher);
	public void del(String publisherID);
	public Publisher findByPublisherID(String publisherID);
	public Publisher findByName(String name);
	public List<Publisher> all();
}
