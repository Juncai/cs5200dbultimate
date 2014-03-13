package bibliophiles.bookstore.domain;

public class OrderItem {
	private Book book;
	private Order order;
	private int count;
	private double subtotal;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	@Override
	public String toString() {
		return "OrderItem [book=" + book + ", order=" + order + ", count="
				+ count + ", subtotal=" + subtotal + "]";
	}
	public OrderItem(Book book, Order order, int count, double subtotal) {
		super();
		this.book = book;
		this.order = order;
		this.count = count;
		this.subtotal = subtotal;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
