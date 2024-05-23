package com.rgt.training.session2basics.online_shopping.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User implements Serializable to do serialization
 * */
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	private List<Order> order;
	private String history;
	private List<Order> ordersPlaced;

	public User() {
		order = new ArrayList<Order>();
		ordersPlaced = new ArrayList<Order>();
		history = "";
	}
	
	public User(String userName, String password, List<Order> order, List<Order> ordersPlaced) {
		super();
		this.userName = userName;
		this.password = password;
		this.order = order;
		this.ordersPlaced = ordersPlaced;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(ArrayList<Order> order) {
		this.order = order;
	}
	
	public void setOrderOfCart(Order order) {
		if (!this.order.contains(order)) {
			this.order.add(order);
		}else {
			System.out.println("product already exist in user carts");
		}
		
	}

	public List<Order> getOrdersPlaced() {
		return ordersPlaced;
	}
	
	public void setOrdersPlaced(List<Order> order) {
		this.ordersPlaced = order;
	}

	public void setOrdersPlacedS(Order ordersPlaced) {
		this.ordersPlaced.add(ordersPlaced);
	}
	
	
	public Order getOrdersByname(String name) {
		Order orders= null;
		for (Order order2 : order) {
			boolean equals = order2.getConfirmationNumber().equals(name);
			if (equals) {
				orders = order2;
			}
		}
		return orders;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public void clear() {
		userName = "";
		password = "";
	}
}
