package com.thecybersphere.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thecybersphere.model.UserInfo;
import com.thecybersphere.service.LoginService;

@RestController
@RequestMapping(path = "/login", produces ="application/json")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/{username}/{password}")
	public Optional<UserInfo> login(@PathVariable("username") String username, @PathVariable("password") String password){
		return loginService.login(username, password);
	}
	
	
}
