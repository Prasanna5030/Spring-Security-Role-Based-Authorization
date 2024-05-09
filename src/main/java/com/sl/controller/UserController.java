package com.sl.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/user/")
public class UserController {
	
	@GetMapping("/home")
	@PreAuthorize("hasAuthority('USER')")
	public String userHome() {
		return "hello User, This is a secured endpoint";
	}

}
