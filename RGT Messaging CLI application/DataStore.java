package com.rgt.training.session2basics.twitter.service;


import java.util.*;
import java.io.*;

import com.rgt.training.session2basics.twitter.dto.Tweet;
import com.rgt.training.session2basics.twitter.dto.User;

/**
 * DataStore class used to store data into text file
 * */
public class DataStore {
	private static int nextId = 1;
	private static final String DATA_FILE = "data.txt";

	/**
	 * generateTweetId is used to update id
	 * */
	public static int generateTweetId() {
		return nextId++;
	}

	/**
	 * saveData is used to save data into text file
	 * */
	public void saveData(Map<String, User> users) throws IOException {
		 FileOutputStream f;
		try {
			f = new FileOutputStream(new File(DATA_FILE));
			ObjectOutputStream s = new ObjectOutputStream(f);
	        s.writeObject(users);
		} catch (FileNotFoundException e) {
			System.out.println("Failed to load data: " + e.getMessage());
		}
	        
	}

	/**
	 * loadDataUsers is used to load data from text file
	 * */
	public Map<String, User> loadDataUsers() {
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File(DATA_FILE)))) {
			Object object = inputStream.readObject();
			if (object instanceof Map) {
				return (Map<String, User>) object;
			} else {
				System.out.println("Invalid data format.");
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Failed to load data: " + e.getMessage());
		}
		return new HashMap<>();
	}
	
	/**
	 * gettingId is used to get data from text file for updating id 
	 * */
	public void gettingId() {
		Map<String, User> loadDataUsers = loadDataUsers();
		for (Map.Entry<String, User> entry : loadDataUsers.entrySet()) {
			User value = entry.getValue();
			Set<Tweet> tweets = value.getTweets();
			for (Tweet tweet : tweets) {
				int id = tweet.getId();
				if (id>=nextId) {
					nextId=id;
					nextId++;
				}
			}
		}
	}

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
