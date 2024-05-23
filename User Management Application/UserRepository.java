package com.example.demo.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class UserRepository {

	private static final String User = null;
	private final String dataDir = "data/users/";

	public User save(User user) throws IOException {
		File file = new File(dataDir + user.getId() + ".ser");
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
			out.writeObject(user);
		}
		return user;
	}

	public User findById(Integer id) throws IOException, ClassNotFoundException {
		File file = new File(dataDir + id + ".ser");
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
			return (User) in.readObject();
		}
	}
	
	public boolean delete(Integer id) throws IOException, ClassNotFoundException {
		boolean flag= false;
		File dir = new File(dataDir);
		for (File file : dir.listFiles()) {
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
				User users= (User) in.readObject();
				if (users.getId()==id) {
					flag = file.delete();
				}
			}
		}
		return flag;
	}

	public List<User> findAll() throws IOException, ClassNotFoundException {
		List<User> users = new ArrayList<>();
		File dir = new File(dataDir);
		for (File file : dir.listFiles()) {
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
				users.add((User) in.readObject());
			}
		}
		return users;
	}
	public User getUserByUsername(String username) throws IOException, ClassNotFoundException {
		User user = null;
		File dir = new File(dataDir);
		for (File file : dir.listFiles()) {
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
				User users= (User) in.readObject();
				if (users.getUserName().equalsIgnoreCase(username)) {
					user = users;
				}
			}
		}
		return user;
	}
}