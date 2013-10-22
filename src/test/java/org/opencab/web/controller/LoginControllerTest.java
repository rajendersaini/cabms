package org.opencab.web.controller;


import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

public class LoginControllerTest extends BaseControllerTest {

	@Ignore
	
	public void loginTest() throws Exception {

		ResultActions res =  mockMvc.perform(get("/auth/login").accept(MediaType.TEXT_HTML));
		
		MvcResult mcres =  res.andReturn();
		

		System.out.println(mcres.getResponse().getForwardedUrl());
		System.out.println(mcres.getResponse().getContentAsString());
		System.out.println(mcres.getResponse().getContentType());
				
	}
}

