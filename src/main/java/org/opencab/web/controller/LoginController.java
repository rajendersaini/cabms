package org.opencab.web.controller;

import javax.validation.Valid;

import org.opencab.bean.LoginInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public String login(@Valid @ModelAttribute("loginInfo") LoginInfo loginInfo, BindingResult result) {
		
		ModelAndView mv = new ModelAndView();
		
		if(result.hasErrors()){
			mv.setViewName(LOGINVIEW);
			mv.addObject("loginInfo", loginInfo);
		}
		
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
