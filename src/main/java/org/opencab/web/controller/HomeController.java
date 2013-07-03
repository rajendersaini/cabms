package org.opencab.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping(value = "/")
	public String home() {
		logger.debug("HomeController: Passing through...");
		return "home";
	}
}