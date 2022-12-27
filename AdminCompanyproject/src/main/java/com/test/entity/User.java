package com.test.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity

public class User {
	
	private int id;
	
	private String Name;
	
	private String Email;
	
	private String Address;
	
	private String Password;
	
	private String role;

	@OneToMany
	List<Company> co=new ArrayList<>();

	
}
