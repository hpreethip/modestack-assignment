package com.modestack.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.modestack.config.JwtTokenUtil;
import com.modestack.dao.UserDao;
import com.modestack.handler.RecordNotFoundException;
import com.modestack.handler.ResponseData;
import com.modestack.model.User;
import com.modestack.model.UserAuth;
import com.modestack.repo.UserRepo;

@Service
public class UserService implements UserDao
{
	@Autowired
	UserRepo userRepo;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Override
	public ResponseEntity<UserAuth> userLogin(User user) throws Exception
	{
		authenticate(user.getUsername(), user.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new UserAuth("Success", token));
	}
	
	private void authenticate(String username, String password) throws Exception
	{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	@Override
	public ResponseEntity<ResponseData> userRegister(User user)
	{
		Optional<User> usernameDb = userRepo.findById(user.getUsername());
		Optional<User> userEmailDb = userRepo.findByEmail(user.getEmail());
		if(usernameDb.isPresent() || userEmailDb.isPresent())
		{
			throw new RecordNotFoundException("User already registered");
		}
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepo.save(user);
		return new ResponseEntity<>(new ResponseData("New user created"), HttpStatus.CREATED);
	}
}