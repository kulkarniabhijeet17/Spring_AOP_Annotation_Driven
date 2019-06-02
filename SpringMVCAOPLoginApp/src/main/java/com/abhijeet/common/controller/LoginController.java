package com.abhijeet.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abhijeet.common.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		model.addAttribute("user", username);
		// System.out.println(username);

		String result = loginService.login(username, password);

		return result;
	}
}