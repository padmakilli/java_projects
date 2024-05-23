package com.rgt.training.session2basics.online_shopping.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import com.rgt.training.session2basics.online_shopping.dto.Product;
import com.rgt.training.session2basics.online_shopping.service.ProductCatalog;

/**
 * ProductCatalogService class of service class
 * of all logics for the given requirements
 */
public class ProductCatalogService implements ProductCatalog {

	private Map<String, Product> products;

	public ProductCatalogService() {
		this.products = new HashMap<>();
	}

	/**
	 * loadProducts to fetch products
	 */
	@Override
	public Map<String, Product> loadProducts() {
		return products;
	}

	/**
	 * saveProducts to save products
	 * */
	@Override
	public boolean saveProducts(Product product) {
		boolean containsKey = products.containsKey(product.getName());
		if (!containsKey) {
			products.put(product.getName(), product);
			System.out.println("Saved successfully");
			return true;
		} else {
			System.out.println("already exist");
			return false;
		}
	}

	/**
	 * getProduct to fetch a product
	 * */
	@Override
	public Product getProduct(String name) {
		boolean containsKey = products.containsKey(name);
		if (containsKey) {
			Product product = products.get(name);
			return product;
		} else {
			System.out.println("product not exists");
			return null;
		}
	}

	/**
	 * setProduct to set products
	 * */
	@Override
	public void setproduct(Map<String, Product> products) {
		this.products = products;
	}

}
