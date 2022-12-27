package com.test.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Company {
	
	
	private int id;
	
	private String cName;
	
	private String cEmail;
	
	private String  cAddress;
	
	
	private String type;
	
	@ManyToOne
	private User user;
	

}
