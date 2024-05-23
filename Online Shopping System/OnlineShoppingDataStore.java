package com.rgt.training.session2basics.online_shopping.serviceimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rgt.training.session2basics.online_shopping.dto.Product;
import com.rgt.training.session2basics.online_shopping.dto.User;

/**
 * DataStore class used to store data into text file
 */
public class OnlineShoppingDataStore {
	private static final String DATA_FILE = "data.json";
	private static final String PRODUCT_FILE = "product.json";
	
	private String customFile = "";

	/**
	 * saveData is used to save user data into file
	 */
	public void saveData(HashMap<String,HashMap<String, User>> users) {
		FileOutputStream f;
		try {
//			List<Map<String, User>> arrayList = new ArrayList<>();
//			arrayList.add(users);
			f = new FileOutputStream(new File(DATA_FILE));
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(f, users);
		} catch (IOException e) {
			System.out.println("Failed to load data: " + e.getMessage());
		}
	}

	/**
	 * saveData is used to save product data into file
	 */
	public void saveProduct(Map<String, Product> products) {
		FileOutputStream f;
		try {
			if (customFile.equals("")) {
				f = new FileOutputStream(new File(PRODUCT_FILE));
			}else {
				f = new FileOutputStream(new File(customFile));
			}			
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(f, products);
		} catch (IOException e) {
			System.out.println("Failed to load data: " + e.getMessage());
		}
	}

	/**
	 * loadDataUsers is used to load data from file
	 */
//	public List<HashMap<String, User>> loadDataUsers() {
//		try {
//			InputStream inputStream = new FileInputStream(new File(DATA_FILE));
//			ObjectMapper objectMapper = new ObjectMapper();
//			TypeReference<List<HashMap<String, User>>> reference = new TypeReference<List<HashMap<String, User>>>() {
//			};
//			
//			String object = objectMapper.readValue(inputStream, String.class);
//			JsonNode readTree = objectMapper.readTree(object);
//			
//			if (readTree instanceof List<?>) {
//				List<HashMap<String, User>> objects = objectMapper.readValue(readTree.toString(),reference);
//				return (List<HashMap<String, User>>) objects;
//			} else {
//				System.out.println("Invalid data format.");
//			}
//		} catch (IOException e) {
//			System.out.println("Failed to load data: " + e.getMessage());
//		}
//		
//		return new ArrayList<HashMap<String, User>>();
//	}
	
	/**
	 * creatingFile is used to new file
	 */
	public void creatingFile(String filename) {
		File file = new File(filename+".json");
		try {
			file.createNewFile();
			this.customFile = filename+".json";
			System.out.println(customFile+" file created successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * filesReading is used to read/create/set the required file
	 */
	public void filesReading() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. Read Existing File");
		System.out.println("2. Add New/Create a File");
		System.out.println("3. Exit");
		System.out.println("Choose the Options : ");
		int nextInt = scanner.nextInt();
		boolean whileOut = true;
		do {
			switch (nextInt) {
			case 1:
				System.out.println("Reading the existing file");
				whileOut = false;
				break;
			case 2:
				System.out.println("Enter file name : ");
				String next = scanner.next();
				creatingFile(next);
				whileOut = false;
				break;
			case 3:
				System.out.println("Exited Successfully");
				whileOut = false;
				break;
			default:
				System.out.println("Invalid option. Please try again.");
				break;
			}
		} while (whileOut);
	}
	
	/**
	 * loadDataUsers is used to load user data
	 */
	public HashMap<String, HashMap<String, User>> loadDataUsers() {
		try {
			InputStream inputStream = inputStream = new FileInputStream(new File(DATA_FILE));
			ObjectMapper objectMapper = new ObjectMapper();
			TypeReference<HashMap<String,HashMap<String, User>>> reference = new TypeReference<HashMap<String,HashMap<String, User>>>() {
			};
			HashMap<String, HashMap<String, User>> object = objectMapper.readValue(inputStream, reference);
//			if (object instanceof ) {
			if (object.size()>0) {
				return (HashMap<String, HashMap<String, User>>) object;
			} else {
				System.out.println("Invalid data format.");
			}
		} catch (IOException e) {
			System.out.println("Failed to load data: " + e.getMessage());
		}
		
		return new HashMap<String, HashMap<String, User>>();
	}

	/**
	 * loadDataProducts is used to load data from file
	 */
	public Map<String, Product> loadDataProducts() {
		try {
			filesReading();
			InputStream inputStream = null;
			if (customFile.equals("")) {
				inputStream = new FileInputStream(new File(PRODUCT_FILE));
			}else {
				inputStream = new FileInputStream(new File(customFile));
			}
			ObjectMapper objectMapper = new ObjectMapper();
			TypeReference<HashMap<String, Product>> reference = new TypeReference<HashMap<String, Product>>() {
			};
			Object object = objectMapper.readValue(inputStream, reference);
			if (object instanceof Map) {
				return (Map<String, Product>) object;
			} else {
				System.out.println("Invalid data format.");
			}
		} catch (IOException e) {
			System.out.println("Failed to load data: " + e.getMessage());
		}
		return new HashMap<>();
	}

//	/**
//	 * gettingId is used to get data from text file for updating id
//	 */
//	public void gettingId() {
//		Map<String, User> loadDataUsers = loadDataUsers();
//		for (Map.Entry<String, User> entry : loadDataUsers.entrySet()) {
//			User value = entry.getValue();
//			Set<Tweet> tweets = value.getTweets();
//			for (Tweet tweet : tweets) {
//				int id = tweet.getId();
//				if (id>=nextId) {
//					nextId=id;
//					nextId++;
//				}
//			}
//		}
//	}

//	public List<Tweet> loadDataTweets() {
//		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
//			// Skip the users object
//			inputStream.readObject();
//
//			Object object = inputStream.readObject();
//			if (object instanceof List) {
//				return (List<Tweet>) object;
//			} else {
//				System.out.println("Invalid data format.");
//			}
//		} catch (IOException | ClassNotFoundException e) {
//			System.out.println("Failed to load data: " + e.getMessage());
//		}
//		return new ArrayList<>();
//	}
}
