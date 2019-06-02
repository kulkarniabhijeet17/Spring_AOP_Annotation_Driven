package com.abhijeet.common.service.impl;

import com.abhijeet.common.service.ChangePasswordService;

public class ChangePasswordServiceImpl implements ChangePasswordService {
	@Override
	public String changePassword(String userID, String oldPassword, String newPassword) {
		return "Success";
	}
}