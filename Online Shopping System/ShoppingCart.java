package com.rgt.training.session2basics.online_shopping.service;

import java.util.Map;

import com.rgt.training.session2basics.online_shopping.dto.Product;

/**
 * ShoppingCart interface used for service class
 * */
public interface ShoppingCart {
	
	/**
	 * addItem to add new product
	 * */
	public boolean addItem(Product product, int quantity);
	
	/**
	 * removeItem to add remove product
	 * */
	public boolean removeItem(Product product);
	
	/**
	 * getTotalPrice to get total price
	 * */
	public double getTotalPrice();
	
	/**
	 * setItems to set many products
	 * */
	public void setItems(Map<String, Product> items);
	
	/**
	 * getItems to fetch all products
	 * */
	public Map<String, Product> getItems();
	
}
