package com.SocialMedia.Chat.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.SocialMedia.Chat.Dto.UserDto;
import com.SocialMedia.Chat.Models.User;
import com.SocialMedia.Chat.Services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@PostMapping("/register")
	public User registerUser(@RequestBody UserDto userDto) {
		return userService.registerUser(userDto);
	}
	
	@GetMapping("/id/{userId}")
    public User findUserById(@PathVariable("userId") Integer userId) {
		
		return userService.findUserById(userId);
		
	}
	
	@GetMapping("/email/{userEmail}")
    public User findUserByEmail(@PathVariable("userEmail") String email) {
		
		return userService.findUserByEmail(email);
		
	}
	
	@GetMapping("/search")
	public List<User> searchUser(@RequestParam("query") String query) {
		return userService.searchUser(query);
	}
	
	@GetMapping("/follow/{reqUserId}/{followUserId}")
	public User followUser(@PathVariable("reqUserId")Integer reqUserId, @PathVariable("followUserId")Integer followUserId) {
		return userService.followUser(reqUserId, followUserId);
		
	}
	
	
	
}
