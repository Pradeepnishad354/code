package com.test.service;



import java.util.List;

import com.test.model.UserDtls;

public interface UserService {

	public UserDtls createUser(UserDtls user);

	public boolean checkEmail(String email);
	
	List<UserDtls> getAllUser();
	
	UserDtls getUserById(Long id);
	
	void deleteUserById(Long  id);

	UserDtls updateUser(UserDtls user );
}
