package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.model.UserDtls;
import com.test.repository.UserRepository;


@Service
//@Transactional(readOnly = false)
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public UserDtls createUser(UserDtls user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		return userRepository.save(user);
	}

	@Override
	public boolean checkEmail(String email) {
		
		return userRepository.existsByEmail(email);
	}

	@Override
	public List<UserDtls> getAllUser() {
		
		return userRepository.findAll();
	}
	
	@Override
	public UserDtls getUserById(Long id) {
		
		return userRepository.findById(id).get();
	}
	

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public UserDtls updateUser(UserDtls user) {
		
		return userRepository.save(user);
	}

	


	
	
}
