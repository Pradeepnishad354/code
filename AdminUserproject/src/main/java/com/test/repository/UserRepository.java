package com.test.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.model.UserDtls;

@Repository
public interface UserRepository extends JpaRepository<UserDtls ,Long> {

	public boolean existsByEmail(String email);

	public UserDtls findByEmail(String email);

}