package org.opencab.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {

	public static final String HOME = "/home";
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping("/")
	public String Home(ModelMap model) {
		logger.debug("Home called"); 
		return "home";
	}

	@RequestMapping(HOME)
	public String home() {
		logger.debug("Home called");
		return "home";
	}
}