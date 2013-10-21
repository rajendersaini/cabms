package org.opencab.web.controller;

import javax.validation.Valid;

import org.opencab.bean.LoginInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth")
public class LoginController {
	public static final String LOGIN = "/login";
	public static final String LOGINFAILED = "/loginfailed";
	public static final String LOGOUT = "/logout";
	public static final String AUTHLOGIN = "/auth/login";
	public static final String AUTHLOGINFAILED = "/auth/loginfailed";
	public static final String AUTHLOGOUT = "/auth/logout";

	public static final String LOGINVIEW = "login";

	@RequestMapping(value = LOGIN, method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("loginInfo") LoginInfo loginInfo) {
		return HomeController.HOME;
	}

	@RequestMapping(value = LOGIN, method = RequestMethod.GET)
	public String loginPage() {
		return LOGINVIEW;
	}

	@RequestMapping(value = LOGINFAILED, method = RequestMethod.GET)
	public String loginFailed(Model model) {
		return LOGINVIEW;
	}

	@RequestMapping(value = LOGOUT, method = RequestMethod.GET)
	public String logout(Model model) {
		return LOGINVIEW;

	}
}
