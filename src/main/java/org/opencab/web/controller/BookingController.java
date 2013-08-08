package org.opencab.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookingController {
	private static final Logger logger = LoggerFactory
			.getLogger(BookingController.class);

	@RequestMapping("/book")
	public String showBooking(ModelMap model) {
		return "book";
	}
}
