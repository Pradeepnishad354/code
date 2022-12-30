package com.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.entity.Company;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

	@Query("from Company as c where c.user.id=:userId")
	List<Company> findCompanyByUser(@Param("userId")Integer userId);
	
	
}
