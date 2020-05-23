package com.modestack.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.modestack.repo.UserRepo;

@Service
public class JwtUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		Optional<com.modestack.model.User> user = userRepo.findById(username);
		if (!user.isPresent())
		{
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new User(user.get().getUsername(), user.get().getPassword(),	new ArrayList<>());
	}
}