package bibliophiles.bookstore.dao;

import java.util.List;

import bibliophiles.bookstore.domain.Address;

public interface AddressDao {
	public void add(Address address);
	public Address findByAddrID(String addrID);
	public void update(Address address);
	public void del(String addrID);
	public List<Address> findByUserID(String userID);
	
	
}
