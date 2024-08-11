package com.SocialMedia.Chat.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SocialMedia.Chat.Dto.UserDto;
import com.SocialMedia.Chat.Models.User;
import com.SocialMedia.Chat.Repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{

	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImplementation(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	@Override
	public User registerUser(UserDto userDto) {
		User user =new User();
		user.setFirst_name(userDto.getFirst_name());
		user.setLast_name(userDto.getLast_name());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
	    return	userRepository.save(user);
	
	}

	@Override
	public User findUserById(Integer id) {
		
		return userRepository.findById(id).get();
		
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User followUser(Integer reqUserId, Integer followUserId) {
	
		User reqUser=findUserById(reqUserId);
		User followUser=findUserById(followUserId);
		reqUser.getFollowings().add(followUserId);
		followUser.getFollowers().add(reqUserId);
		userRepository.save(reqUser);
		userRepository.save(followUser);
		return reqUser;
	}

	@Override
	public User updateUser(UserDto userDto,Integer userId) {
		return null;
	}

	@Override
	public List<User> searchUser(String query) {
		return userRepository.searchUser(query);
	}

}
