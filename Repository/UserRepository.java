package com.SocialMedia.Chat.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.SocialMedia.Chat.Models.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmail(String email);
	
	@Query("select u FROM User u WHERE u.first_name LIKE %:query% OR u.last_name LIKE %:query% OR u.email LIKE %:query%")
	public List<User> searchUser(@Param("query") String query);
	
}
