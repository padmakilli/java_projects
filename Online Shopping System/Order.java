package com.rgt.training.session2basics.online_shopping.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *  Order implements Serializable to do serialization
 * */
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String confirmationNumber;
	
	private Map<String, Product> items;
	
	private static double totalPrice;

	public Order() {
		super();
		this.confirmationNumber = "";
		this.items = new HashMap<>();
		Order.totalPrice = 0;
	}

	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	public Map<String, Product> getProductsOrdered() {
		return items;
	}

	public void setProductsOrdered(Map<String, Product> items) {
		this.items = items;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		Order.totalPrice = totalPrice;
	}
	
	public void setProductsOrders(Product product) {
		items.put(product.getName(), product);
	}
	
	public void setCartProductsOrder(Product product,String name) {
		if (items!=null) {
			if (!items.containsKey(name)) {
				this.items.put(name, product);
			}else {
				System.out.println("product already exist in carts");
			}
		}		
	}

}
