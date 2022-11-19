package com.kaffotek.nyang.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.kaffotek.nyang.shared.dto.UserDto;

public interface UserService extends UserDetailsService{
	UserDto createUser(UserDto user);
	UserDto getUser(String email);
	UserDto getUserByUserId(String id);
	UserDto updateUser(String userId, UserDto userDto);
	void deleteUser(String id);
	List<UserDto> getUsers(int page, int limit);
}
