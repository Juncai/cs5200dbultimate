package bibliophiles.bookstore.domain;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;



public class Order {
	private String orderID;
	private Date ordertime;
	private double total;
	private User user;
	private Address address;
	private int state;
	
	private Set<OrderItem> orderItemSet = new LinkedHashSet<OrderItem>();
	
	public void addOrderItem(OrderItem orderItem) {
		orderItemSet.add(orderItem);
	}
	
	public void removeOrderItem(OrderItem orderItem) {
		orderItemSet.remove(orderItem);
	}
	
	
	public Set<OrderItem> getOrderItemSet() {
		return orderItemSet;
	}

	public void setOrderItemSet(Set<OrderItem> orderItemSet) {
		this.orderItemSet = orderItemSet;
	}

	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

	
	public Order(String orderID, Date ordertime, double total, User user,
			Address address, int state, Set<OrderItem> orderItemSet) {
		super();
		this.orderID = orderID;
		this.ordertime = ordertime;
		this.total = total;
		this.user = user;
		this.address = address;
		this.state = state;
		this.orderItemSet = orderItemSet;
	}
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", ordertime=" + ordertime
				+ ", total=" + total + ", user=" + user + ", address="
				+ address + ", state=" + state + ", orderItemSet="
				+ orderItemSet + "]";
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
