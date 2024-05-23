package com.rgt.training.session2basics.online_shopping.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.UUID;

import com.rgt.training.session2basics.online_shopping.dto.Order;
import com.rgt.training.session2basics.online_shopping.dto.Product;
import com.rgt.training.session2basics.online_shopping.dto.User;
import com.rgt.training.session2basics.online_shopping.service.ProductCatalog;
import com.rgt.training.session2basics.online_shopping.service.ShoppingCart;

/**
 * OnlineShoppingService class of service class
 * of all logics for the given requirements
 */
public class OnlineShoppingService {

	private HashMap<String, HashMap<String, User>> usersd;

	private HashMap<String, User> users;

	private Map<String, Product> products;

	private OnlineShoppingDataStore dataStore;

	private ProductCatalog productService;

	private ShoppingCart shoppingCart;


	/**
	 * OnlineShoppingService constructor to invoke/initialize some values
	 */
	public OnlineShoppingService() {
		this.usersd = new HashMap<String, HashMap<String, User>>();
		this.users = new HashMap<>();
		this.productService = new ProductCatalogService();
		this.shoppingCart = new ShoppingCartService();
		this.dataStore = new OnlineShoppingDataStore();
		this.usersd = dataStore.loadDataUsers();
		this.products = dataStore.loadDataProducts();
		setProductsToList(products);
		setUsersToMap(usersd);
	}

	/**
	 *setProductsToList to set the products to the given list
	 */
	private void setProductsToList(Map<String, Product> productsList) {
		productService.setproduct(productsList);
	}

	/**
	 * setUsersToMap to set the list of users to the above map
	 */
	public void setUsersToMap(HashMap<String, HashMap<String, User>> users) {
		for (Entry<String, HashMap<String, User>> usersMap : usersd.entrySet()) {
			for (Entry<String, User> entrySet : usersMap.getValue().entrySet()) {
				this.users.put(entrySet.getKey(), entrySet.getValue());
			}
		}
	}

	/**
	 * listingUsers to get the User from the above list
	 */
	public boolean listingUsers(String username) {
		User user = new User();
		boolean userList = false;
		for (Entry<String, HashMap<String, User>> usersMap : usersd.entrySet()) {
			HashMap<String, User> value = usersMap.getValue();
			if (value.size() > 0) {
				if (value.containsKey(username)) {
					user = value.get(username);
					users.put(username, user);
					userList = true;
				}
			} else {
				users = new HashMap<>();
			}
		}
		return userList;
	}


	/**
	 * loadAllProducts to get the products from the above list
	 */
	public void loadAllProducts() {
		System.out.println("List of Products");
		Map<String, Product> entrySet = productService.loadProducts();
		for (Entry<String, Product> entry : entrySet.entrySet()) {
			System.out.println("Product Name : " + entry.getValue().getName() + " Price : "
					+ entry.getValue().getPrice() + " quantity : " + entry.getValue().getQuantity());
		}
	}

	/**
	 * stringScanner for handling exceptions by scanner class
	 */
	public String stringScanner(Scanner scanner) {
		String name = "";
		boolean str = false;
		while (!str) {
			try {
				name = scanner.next();
				str = true;
			} catch (Exception e) {
				System.out.println("invalid input format");
			}
		}
		return name;
	}

	/**
	 * intScanner for handling exceptions by scanner class
	 */
	public int intScanner(Scanner scanner) {
		int name = 0;
		boolean str = false;
		while (!str) {
			try {
				name = Integer.parseInt(scanner.next());
				str = true;
			} catch (Exception e) {
				System.out.println("invalid input format");
			}
		}
		return name;
	}

	/**
	 * doubleScanner for handling exceptions by scanner class
	 */
	public double doubleScanner(Scanner scanner) {
		double name = 0;
		boolean str = false;
		while (!str) {
			try {
				name = Integer.parseInt(scanner.next());
				str = true;
			} catch (Exception e) {
				System.out.println("invalid input format");
			}
		}
		return name;
	}

	/**
	 * saveProduct to save products
	 */
	public void saveProduct(Scanner scanner) {

		System.out.println("enter product name : ");
		String name = stringScanner(scanner);
		System.out.println("enter product description : ");
		String description = stringScanner(scanner);
		System.out.println("enter product price : ");
		double price = doubleScanner(scanner);
		System.out.println("enter product quantity : ");
		int quantity = intScanner(scanner);
		Product product = new Product();
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setQuantity(quantity);
		productService.saveProducts(product);
		dataStore.saveProduct(products);
	}

	/**
	 * getProductByName to get product by name
	 */
	public void getProductByName(Scanner scanner) {
		System.out.println("enter product name : ");
		String name = stringScanner(scanner);
		Product product = productService.getProduct(name);
		System.out.println(" " + product.getName() + " " + product.getPrice() + " " + product.getQuantity());
	}

	/**
	 * updateUserAndProduct to update both product and user
	 */
	public boolean updateUserAndProduct(Product product, User user) {
		boolean flag = false;
		try {
			products.put(product.getName(), product);
			productService.setproduct(products);
			dataStore.saveProduct(products);

			users.put(user.getUserName(), user);
			usersd.put("user", users);
			dataStore.saveData(usersd);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	/**
	 * updateUserAndProduct to update user
	 */
	public boolean updateUser(User user) {
		boolean flag = false;
		try {
			users.put(user.getUserName(), user);
			usersd.put("user", users);
			dataStore.saveData(usersd);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	/**
	 * addUserToList to add user to above list
	 */
	public void addUserToList(User user) {
		try {
			users.put(user.getUserName(), user);
			usersd.put("user", users);
			dataStore.saveData(usersd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * generateString to generate random string 
	 */
	public static String generateString() {
		String uuid = UUID.randomUUID().toString().toUpperCase();
		return uuid;
	}

	/**
	 * addProductToCart to add product to the cart
	 */
	public void addProductToCart(Scanner scanner, String username) {
		System.out.println("enter product name : ");
		String name = stringScanner(scanner);
		System.out.println("enter product quantity : ");
		int quantity = intScanner(scanner);
		boolean flag = products.containsKey(name);
		Product product = new Product();
		if (flag) {
			User user = users.get(username);
			Product product2 = products.get(name);

			int quantity2 = products.get(name).getQuantity();
			if (quantity <= quantity2) {
				product.setDescription(product2.getDescription());
				product.setName(product2.getName());
				product.setPrice(product2.getPrice());
				product.setQuantity(quantity);
//				 make method return type as boolean
				Map<String, Product> items = shoppingCart.getItems();
				boolean containsKey = items.containsKey(name);
				if (containsKey) {
					System.out.println("Order Already exists in Cart");
				} else {
					shoppingCart.addItem(product, quantity);
					double totalPrice = shoppingCart.getTotalPrice();
					Order order = new Order();
					order.setConfirmationNumber(generateString());
					order.setTotalPrice(totalPrice);
					order.setCartProductsOrder(product, name);
					user.setOrderOfCart(order);
					product2.setQuantity(quantity2 - quantity);
					boolean updateUserAndProduct = updateUserAndProduct(product2, user);
					if (updateUserAndProduct) {
						System.out.println("Added to Cart");
					}
				}
			} else {
				System.out.println("products are less in quantity");
			}
		} else {
			System.out.println("Product not in list");
		}
	}

	/**
	 * getMyCarts to get my cart list
	 */
	public void getMyCarts(String username) {
		boolean containsKey = users.containsKey(username);
		if (containsKey) {
			User user = users.get(username);
			List<Order> order = user.getOrder();
			if (order.size() > 0) {
				for (Order order2 : order) {
					Map<String, Product> productsOrdered = order2.getProductsOrdered();
					for (Entry<String, Product> entrySet : productsOrdered.entrySet()) {
						Product value = entrySet.getValue();
						System.out.println(order2.getConfirmationNumber() + " " + value.getName() + " "
								+ value.getPrice() + " " + value.getQuantity());
					}
				}
			}

		}
	}

	/**
	 * placeOrderOrPurchase to purchase the placed order
	 */
	public void placeOrderOrPurchase(String username) {
		System.out.println("Checking out");
		User user = users.get(username);
		List<Order> order = user.getOrdersPlaced();
		String history = "";
		double price = 0;
		for (Order order2 : order) {
			Map<String, Product> productsOrdered = order2.getProductsOrdered();
			for (Entry<String, Product> item : productsOrdered.entrySet()) {
				Product value = item.getValue();
				String data = "Co-Number : " + order2.getConfirmationNumber() + " Product name : " + value.getName()
						+ " Quantity : " + value.getQuantity() + " price : " + value.getPrice()+" ";
				history += data;
				price+= value.getPrice();
//				shoppingCart.removeItem(value);
			}
		}
		user.setOrdersPlaced(new ArrayList<Order>());
		history += " Total Price : " + price;
		Date date = new Date();
		if (user.getHistory().equals("")) {
			user.setHistory("Order Date : " + date.toString() + " :- " + history + " \n");
		} else {
			user.setHistory(user.getHistory() + " " + "Order Date : " + date.toString() + " :- " + history + " \n");
		}
		if (shoppingCart.getItems().size() > 0) {
			System.out.println("Transcation is not Successfull");
		} else {
			System.out.println("Purcased items successfully");
			updateUser(user);
		}
	}

	/**
	 * placeOrder to place an order
	 */
	public void placeOrder(String username) {
		System.out.println("placing order");
		User user = users.get(username);
		List<Order> order = user.getOrder();
		if (order.size() > 0) {
			if (user.getOrdersPlaced().size() > 0) {
				for (Order order2 : order) {
					user.setOrdersPlacedS(order2);
				}
				user.setOrder(new ArrayList<Order>());
				System.out.println("orders placed successfully");
			} else {
				user.setOrdersPlaced(order);
				user.setOrder(new ArrayList<Order>());
				System.out.println("orders placed successfully");
			}
			shoppingCart.setItems(new HashMap<String, Product>());

		} else {
			System.out.println("No items are in cart to place order");
		}

		if (user.getOrdersPlaced().size() > 0) {
			System.out.println("Purcased items successfully");
			updateUser(user);
		} else {
			System.out.println("Transcation is not Successfull");
		}
	}

	/**
	 * getPlacedOrders to get placed orders
	 */
	public void getPlacedOrders(String username) {
		System.out.println("Getting placed orders");
		User user = users.get(username);
		List<Order> order = user.getOrdersPlaced();
		if (order.size() > 0) {
			for (Order order2 : order) {
				Map<String, Product> productsOrdered = order2.getProductsOrdered();
				for (Entry<String, Product> entrySet : productsOrdered.entrySet()) {
					Product value = entrySet.getValue();
					System.out.println(order2.getConfirmationNumber() + " " + value.getName() + " " + value.getPrice()
							+ " " + value.getQuantity());
				}
			}
		}
	}

	/**
	 * removeProductFromCart to remove product from cart
	 */
//	public void removeProductFromCart(Product product, int quantity) {
	public void removeProductFromCart(Scanner scanner, String username) {
		System.out.println("enter order to remove");
		String name = scanner.next();
		System.out.println("enter quantity to remove");
		int quantity = scanner.nextInt();

		User user = users.get(username);

		Order ordersByname = user.getOrdersByname(name);
		if (ordersByname != null) {
			String productName = "";
			Map<String, Product> productsOrdered = ordersByname.getProductsOrdered();
			for (Entry<String, Product> entry : productsOrdered.entrySet()) {
				Product value = entry.getValue();
				productName = value.getName();
			}
			if (productName != null) {
				Product product2 = products.get(productName);
				Product product = new Product();
				product.setName(product2.getName());
				product.setDescription(product2.getDescription());
				product.setPrice(product2.getPrice());

				Product product3 = productsOrdered.get(product.getName());

				if (product3.getQuantity() >= quantity) {
					boolean addItem = false;
					if (product3.getQuantity() <= quantity) {
						product.setQuantity(product2.getQuantity() + quantity);
						user.getOrder().remove(ordersByname);
						addItem = shoppingCart.removeItem(product);

					} else {
						product.setQuantity(product2.getQuantity() + quantity);
						addItem = shoppingCart.addItem(product, product3.getQuantity() - quantity);
						List<Order> order = user.getOrder();
						for (Order order2 : order) {
							order2.setTotalPrice(shoppingCart.getTotalPrice());
						}
					}
					if (addItem) {
						updateUserAndProduct(product, user);
					}
				} else {
					System.out.println("please enter valid quantity");
				}
			} else {
				System.out.println("product not exists in order");
			}
		} else {
			System.out.println("order dont exist in the cart");
		}

	}

	/**
	 * getTotalPrice to get total price
	 */
	public void getTotalPrice(String username) {
		double totalPrice = shoppingCart.getTotalPrice();
		System.out.println(totalPrice);
	}

	/**
	 * registerUser to add new user
	 */
	public String registerUser(User user) {
		String message = "";
		String userName = user.getUserName();
		boolean listingUsers = listingUsers(userName);
		if (!listingUsers) {
			boolean containsKey = users.containsKey(userName);
			if (!containsKey) {
//				List<OrderHistory> histories = new ArrayList<>();
//				OrderHistory history = new OrderHistory();
//				List<Order> list = new ArrayList<>();
//				Order order = new Order();
//				list.add(order);
//				history.setOrders(list);
//				histories.add(history);
//				user.setOrderHistorys(histories);

				users.put(userName, user);
				addUserToList(user);
				message = "Registered SuccessFully";
			} else {
				message = "Try with Another UserName! " + userName + " already exits";
			}
		} else {
			System.out.println("users with name already exist with in list");
		}

		return message;
	}

	/**
	 * getTotalPriceOfPlacedOrders to get total price of orders place
	 */
	public void getTotalPriceOfPlacedOrders(String username) {
		User user = users.get(username);
		List<Order> ordersPlaced = user.getOrdersPlaced();
		double totalPrice = 0;
		for (Order order2 : ordersPlaced) {
			for (Entry<String, Product> entrySet : order2.getProductsOrdered().entrySet()) {
				Product value = entrySet.getValue();
				totalPrice+=value.getPrice();
			}
		}
		System.out.println("Total Price of Orders Placed : " + totalPrice);
	}

	/**
	 * login used for logging in for user
	 */
	public boolean login(String username, String password) {
		boolean listingUsers = listingUsers(username);
		if (listingUsers) {
			if (users.isEmpty()) {
				System.out.println("No users listed! Register and please Login Again");
				return false;
			} else {

				for (HashMap.Entry<String, User> entry : users.entrySet()) {
					if (entry.getValue() != null) {
						if (entry.getValue().getUserName().equalsIgnoreCase(username.toLowerCase())
								&& entry.getValue().getPassword().equals(password)) {
							User value = entry.getValue();
							List<Order> order = value.getOrder();
							Map<String, Product> productsOrdered = new HashMap<>();
							if (order.size() > 0) {
								for (Order order2 : order) {
									productsOrdered = order2.getProductsOrdered();
								}
							}
							this.shoppingCart.setItems(productsOrdered);
							System.out.println("Login successful!");
							return true;
						}

					} else {
						System.out.println("Invalid username or password.");
						return false;
					}
				}
			}
		} else {
			System.out.println("user not exist with in list");
		}
		return false;
	}
	
	/**
	 * getOrderHistory to get orders placed history
	 */
	public void getOrderHistory(String username) {
		User user = users.get(username);
		String history = user.getHistory();
		String[] split = history.split("\n");
		System.out.println("user orders history : ");
		for (String string : split) {
			System.out.println(string);
		}
	}

	/**
	 * getAllUsers to fetch all users
	 */
	public void getAllUsers() {
		System.out.println("List of User names");
		for (Map.Entry<String, User> entry : users.entrySet()) {
			System.out.println("UserName : " + entry.getValue().getUserName()
//					+ " posts - " + entry.getValue().getTweets().size()
			);
		}
	}

//	public void placeOrderOrPurchase(String username) {
//		System.out.println("Checking out");
//		User user = users.get(username);
//		List<Order> order = user.getOrder();
//		String history = "";
//		double price = shoppingCart.getTotalPrice();
//		for (Order order2 : order) {
//			Map<String, Product> productsOrdered = order2.getProductsOrdered();
//			for (Entry<String, Product> item : productsOrdered.entrySet()) {
//				Product value = item.getValue();
//				String data = "Co-Number : " + order2.getConfirmationNumber() + " Product name : " + value.getName()
//				+" Quantity : "+value.getQuantity()+" price : "+value.getPrice();
//				history += data ;
//				shoppingCart.removeItem(value);
//			}
//		}
//		user.setOrder(new ArrayList<Order>());
//		history += " Total Price : "+price;
//		Date date = new Date();
//		if (user.getHistory().equals("")) {
//			user.setHistory("Order Date : "+date.toString()+" :- "+history+" \n");
//		}else {
//			user.setHistory(user.getHistory()+" "+"Order Date : "+date.toString()+" :- "+" \n");
//		}
//
////		OrderHistory history = new OrderHistory();
////		for (Order order2 : order) {
////			history.addOrder(order2);
////			user.setOrderHistory(history);
////		}
////		if (history.getOrders().size()>0) {
////			user.setOrder(new ArrayList<Order>());
////			List<Order> orders = history.getOrders();
////			for (Order order2 : orders) {
////				Map<String, Product> productsOrdered = order2.getProductsOrdered();
////				for (Entry<String, Product> order3 : productsOrdered.entrySet()) {
////					Product value = order3.getValue();
////					shoppingCart.removeItem(value);
////				}
////			}
////			
////		}
//		if (shoppingCart.getItems().size() > 0) {
//			System.out.println("Transcation is not Successfull");
//		} else {
//			System.out.println("Purcased items successfully");
//			updateUser(user);
//		}
//	}

}
