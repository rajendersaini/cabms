package org.opencab.web.controller;


import org.opencab.db.model.UserLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/user/create", method = RequestMethod.GET)
	public ModelAndView newShopPage() {
		ModelAndView mav = new ModelAndView("user-new", "user", new UserLogin());
		return mav;
	}
}
