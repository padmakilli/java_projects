package com.rgt.training.session2basics.online_shopping.serviceimpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.rgt.training.session2basics.online_shopping.dto.Product;
import com.rgt.training.session2basics.online_shopping.service.ShoppingCart;

/**
 * ShoppingCartService class of service class
 * of all logics for the given requirements
 */
public class ShoppingCartService implements ShoppingCart {
	
	private Map<String, Product> items;

	/**
	 * ShoppingCartService class constructor
	 */
	public ShoppingCartService() {
		this.items = new HashMap<>();
	}

	/**
	 * addItem to add new product
	 * */
	@Override
	public boolean addItem(Product product, int quantity) {
		boolean flag = false;
		if (product!=null) {
			boolean containsKey = items.containsKey(product.getName());
			if (containsKey) {
				Product product2 = items.get(product.getName());
				product2.setQuantity(quantity);
				items.put(product2.getName(), product2);
			}else {
				product.setQuantity(quantity);
				items.put(product.getName(), product);
				System.out.println("added");
			}
			flag= true;
		}else {
			System.out.println("product not exists");
		}
		return flag;
	}

	/**
	 * removeItem to add remove product
	 * */
	@Override
	public boolean removeItem(Product product) {
		boolean flag = items.containsKey(product.getName());
		boolean message = false;
		if (flag) {
			items.remove(product.getName());
			System.out.println("removed");
			message = true;
			
		}else{
			System.out.println("not removed");
		}
		return message;
	}

	/**
	 * getTotalPrice to get total price
	 * */
	@Override
	public double getTotalPrice() {
		Set<Entry<String, Product>> entrySet = items.entrySet();
		double totalPrice = 0;
		for (Entry<String, Product> entry : entrySet) {
			double price = 0;
			Product value = entry.getValue();
			int quantity = value.getQuantity();
			price += value.getPrice();
			price *= quantity;
			totalPrice += price;
		}
		return totalPrice;
	}

	/**
	 * setItems to set many products
	 * */
	@Override
	public void setItems(Map<String, Product> items) {
		this.items = items;
	}

	/**
	 * getItems to fetch all products
	 * */
	@Override
	public Map<String, Product> getItems() {
		return items;
	}

}
