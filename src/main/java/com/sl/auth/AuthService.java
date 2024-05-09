package com.sl.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sl.entity.User;
import com.sl.repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserRepository userRepository;
	

	public String register(RegisterRequest request) {
		User user = User.builder()
				      .username(request.getUsername())
				      .password(passwordEncoder.encode(request.getPassword()))
				      .email(request.getEmail())
				      .roles(request.getRoles())
				      .build();
		
		userRepository.save(user);
		return "user registered successfully";
	}

	public String authenticate(AuthenticationRequest request) {
		
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())); 
		User user= userRepository.findByUsername(request.getUsername()).orElseThrow(()-> new UsernameNotFoundException("user not found"));
		return "Authentication Success";
	}

}
