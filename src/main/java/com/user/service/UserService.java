package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.user.model.User;
import com.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User registerUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getUsers(User user) {
		return userRepository.findAll();
	}

	public List<User> findUserWithSorting(String field) {
		return userRepository.findAll(Sort.by(Sort.Direction.ASC, field));
	}

	public Page<User> findUsersPagination(int offSet, int pageSize) {
		Page<User> findAll = userRepository.findAll(PageRequest.of(offSet, pageSize));
		return findAll;
	}

}
