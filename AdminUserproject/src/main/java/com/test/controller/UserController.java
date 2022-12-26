package com.test.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.model.UserDtls;
import com.test.repository.UserRepository;
import com.test.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;;

	@Autowired
	private UserService userService;
	
	@ModelAttribute
	private void userDetails(Model m, Principal p) {
		String email = p.getName();
		UserDtls user = userRepository.findByEmail(email);

		m.addAttribute("user", user);

	}

	@GetMapping("/")
	public String home() {
		return "home";
	}



	@GetMapping("/listuser")
	public String listUser(Model model) {
		
		model.addAttribute("users" ,userService.getAllUser());
		
		return "users";
	}
	
	
	@GetMapping("/users/{id}")
	public String  deleteUserById(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
		
		return "redirect:/user/listuser";
		

	}	
	
	
	@GetMapping("/users/edit/{id}")
	public String editUserForm(@PathVariable Long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "edit_users";
	
	}
	
	@PostMapping("/users/{id}")
	public String updateUser(@PathVariable("id") Long id,		
			@ModelAttribute("user") UserDtls user ,Model model)
	{
		UserDtls existingUser = userService.getUserById(id);	
		existingUser.setId(id);
		existingUser.setFullName(user.getFullName());
		existingUser.setEmail(user.getEmail());
		existingUser.setAddress(user.getAddress());
		existingUser.setQualification(user.getQualification());
		userService.updateUser(existingUser);
		return "redirect:/user/listuser";
	
	}

}