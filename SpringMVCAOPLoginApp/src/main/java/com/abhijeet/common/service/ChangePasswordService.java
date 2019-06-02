package com.abhijeet.common.service;

public interface ChangePasswordService {
	String changePassword(String userID, String oldPassword, String newPassword);
}