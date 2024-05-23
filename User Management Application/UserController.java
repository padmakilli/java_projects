package com.example.demo.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.UserDetailsServiceImpl;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/api/users")
//@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody @Valid User user) throws IOException {
		User createUser = userService.createUser(user);
		if (createUser != null) {
			return ResponseEntity.ok(createUser);
		} else {
			return ResponseEntity.badRequest().body(createUser);
		}
	}

	@GetMapping("getbyid/{id}")
//	@Secured("{ROLE_USER}")
	public ResponseEntity<User> getUser(@PathVariable("id") @Range(min = 1, message = "invalid id") Integer id)
			throws IOException, ClassNotFoundException {
		User user = userService.getUser(id);
		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
//	@PostMapping("/login")
//	public String login(@RequestBody @Valid User user) {
//		Authentication authentication = authenticationManager.authenticate(
//		        new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
//		
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		
//		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//		authorities.forEach(x->{
//			System.out.println(x);
//		});
//		
////		 List<String> roles = userDetails.getAuthorities().stream()
////			        .map(item -> item.getAuthority())
////			        .collect(Collectors.toList());
//		 return null;
//	}

	@GetMapping("/getall")
//	@Secured("{ROLE_USER}")
	public ResponseEntity<List<User>> getUsers() throws IOException, ClassNotFoundException {
		return ResponseEntity.ok(userService.getUsers());
	}

	@PutMapping("update/{id}")
//	@Secured("{ROLE_USER}")
	public ResponseEntity<User> updateUser(@RequestBody @Valid User user,
			@PathVariable("id") @Range(min = 1, message = "invalid id") Integer id)
			throws IOException, ClassNotFoundException {
		User user2 = userService.updateUser(user, id);
		if (user2 != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@DeleteMapping("delete/{id}")
//	@Secured("{ROLE_USER}")
	public ResponseEntity<String> deleteUser(
			@PathVariable("id") @Range(min = 1, message = "invalid id") Integer id)
			throws IOException, ClassNotFoundException {
		boolean user2 = userService.delete(id);
		if (user2) {
			return ResponseEntity.ok("success");
		} else {
			return ResponseEntity.badRequest().body("failure");
		}
	}
}