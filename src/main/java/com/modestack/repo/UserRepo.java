package com.modestack.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.modestack.model.User;

@Repository
public interface UserRepo extends MongoRepository<User, String>
{
	@Query("{ username: ?0, password: ?1 }")
	Optional<User> findByUsernameAndPassword(String username, String password);

	@Query("{ email: ?0 }")
	Optional<User> findByEmail(String email);
}