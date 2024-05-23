package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	public User createUser(User user) throws IOException {
		long currentTimeMillis = System.currentTimeMillis();
		user.setId((int)currentTimeMillis);
		User saveUSer = new User();
		saveUSer.setUserName(user.getUserName());
		saveUSer.setId(user.getId());
		saveUSer.setPassword(encoder.encode(user.getPassword()));
		saveUSer.setConfirmPassword(user.getConfirmPassword());
		saveUSer.setRole("ROLE_USER");
		return userRepository.save(saveUSer);
	}
	
	public User createAdmin(User user) throws IOException {
		long currentTimeMillis = System.currentTimeMillis();
		user.setId((int)currentTimeMillis);
		User saveUSer = new User();
		saveUSer.setId(user.getId());
		saveUSer.setPassword(user.getPassword());
		saveUSer.setConfirmPassword(user.getConfirmPassword());
		saveUSer.setRole("ROLE_ADMIN");
		return userRepository.save(user);
	}

	public User getUser(Integer id) throws IOException, ClassNotFoundException {
		return userRepository.findById(id);
	}

	public List<User> getUsers() throws IOException, ClassNotFoundException {
		return userRepository.findAll();
	}
	
	public User updateUser(User user,Integer id) throws IOException, ClassNotFoundException {
		User findById = userRepository.findById(id);
		if (findById!=null) {
			findById.setUserName(user.getUserName());
			findById.setPassword(user.getPassword());
			findById.setConfirmPassword(user.getPassword());
		}
		return userRepository.save(findById);
	}
	
	public boolean delete(Integer id) throws IOException, ClassNotFoundException {
		return userRepository.delete(id);
	}
}
