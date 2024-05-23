package com.rgt.training.session2basics.online_shopping.service;

import java.util.Map;

import com.rgt.training.session2basics.online_shopping.dto.Product;

/**
 * ProductCatalog interface used for service class
 * */
public interface ProductCatalog {
	
	/**
	 * loadProducts to fetch products
	 * */
	public Map<String, Product> loadProducts();
	
	/**
	 * saveProducts to save products
	 * */
	public boolean saveProducts(Product product);
	
	/**
	 * getProduct to fetch a product
	 * */
	public Product getProduct(String name);
	
	/**
	 * setProduct to set products
	 * */
	public void setproduct(Map<String, Product> products);
	
}
