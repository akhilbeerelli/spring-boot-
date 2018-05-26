package com.example.demo2;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController



public class UserController {
	@Autowired
	private UserRepository userRepository;

	
	

	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/users/user/{emailAddress}")
	public Optional<User> getUser(@PathVariable String emailAddress) {
			return userRepository.findById(emailAddress);
		}

	@DeleteMapping("/users/user/{emailAddress}")
	public boolean deleteUser(@PathVariable String emailAddress) {
		userRepository.deleteById(emailAddress);
		return true;
	}

	@PostMapping("users/user/save")
	public User updateUser(@RequestBody User user) {
		return userRepository.save(user);	
	}

//	@PutMapping("/save/{id}")
//	public User upduser(@RequestBody User user,@PathVariable Integer id) {
//		return userRepository.save(user);
//				}

}
