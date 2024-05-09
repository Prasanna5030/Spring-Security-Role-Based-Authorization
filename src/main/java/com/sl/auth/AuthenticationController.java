package com.sl.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthService authService;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterRequest request){
		return new ResponseEntity<String>(authService.register(request),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/authenticate")
   public ResponseEntity<String> register(@RequestBody AuthenticationRequest request){
	   return new ResponseEntity<String>(authService.authenticate(request),HttpStatus.ACCEPTED);
	}
}
