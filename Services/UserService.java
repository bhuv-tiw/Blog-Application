package com.SocialMedia.Chat.Services;

import java.util.List;

import com.SocialMedia.Chat.Dto.UserDto;
import com.SocialMedia.Chat.Models.User;

public interface UserService {

    public User registerUser(UserDto userDto);
	public User findUserById(Integer id);
	public User findUserByEmail(String email);
	public User followUser(Integer reqUserId,Integer followUserId);
	public User updateUser(UserDto userDto,Integer userId) ;
	public List<User> searchUser(String query);
}
