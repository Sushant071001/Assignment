package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/rest")
public class ApplicationController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> getUsers(User user) {
		return userService.getUsers(user);
	}

	@GetMapping("/users/{field}")
	public List<User> getUsersWithSoet(@PathVariable String field) {
		return userService.findUserWithSorting(field);
	}

	@GetMapping("/page/{offSet}/{pageSize}")
	public Page<User> getUsersPage(@PathVariable int offSet, @PathVariable int pageSize) {
		return userService.findUsersPagination(offSet, pageSize);
	}

}
