package com.user.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.user.model.User;
import com.user.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with email: " + email);
		}

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				new ArrayList<>());
	}

//	public User findByEmail(String email) {
//		return repository.findByEmail(email);
//	}
//
//	public List<User> getUsers(User user) {
//		return repository.findAll();
//	}
//
//	public List<User> findUserWithSorting(String field) {
//		return repository.findAll(Sort.by(Sort.Direction.ASC, field));
//	}
//
//	public Page<User> findUsersPagination(int offSet, int pageSize) {
//		Page<User> findAll = repository.findAll(PageRequest.of(offSet, pageSize));
//		return findAll;
//	}

}
