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
public class HomeController {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping("/")
	public String velo(ModelMap model) {
		return "hello_velocity";
	}

}