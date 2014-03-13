package bibliophiles.bookstore.domain;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	private Map<String, CartItem> map = new LinkedHashMap<String, CartItem>();
	private double total;
	
	public void add(CartItem cartItem) {
		String isbn = cartItem.getBook().getIsbn();
		CartItem _item = map.get(isbn);
		if (_item != null) {
			_item.setCount(cartItem.getCount() + _item.getCount());
			_item.setSubtotal(cartItem.getSubtotal() + _item.getSubtotal());
			map.put(isbn, _item);
		} else {
			map.put(isbn, cartItem);
		}
		this.total += cartItem.getSubtotal();			
	}
	
	public void del(String isbn) {
		CartItem item = map.remove(isbn);
		this.total -= item.getSubtotal();
	}
	
	public void clear() {
		map.clear();
		total = 0;
	}
	
	public Collection<CartItem> getCartItems() {
		return map.values();
	}
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
