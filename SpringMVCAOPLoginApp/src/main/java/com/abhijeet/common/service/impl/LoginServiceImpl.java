package com.abhijeet.common.service.impl;

import org.springframework.stereotype.Service;

import com.abhijeet.common.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Override
	public String login(String userID, String password) {
		return "homePage";
	}
}