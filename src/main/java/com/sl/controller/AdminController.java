package com.sl.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@GetMapping("/home")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String adminhome() {
		return " Hello admin , this is a secured end point";
	}

}
