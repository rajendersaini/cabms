package org.opencab.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactusController {
	private static final Logger logger = LoggerFactory
			.getLogger(ContactusController.class);
	@RequestMapping("/contact")
	public String velo(ModelMap model) {
		return "contact";
	}

}
