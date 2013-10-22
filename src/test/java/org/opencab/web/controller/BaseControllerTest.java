package org.opencab.web.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.opencab.config.AppConfig;
import org.opencab.config.BeanConfig;
import org.opencab.config.JUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(JUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = { BeanConfig.class, AppConfig.class })
@WebAppConfiguration
public class BaseControllerTest {
	@Autowired
	WebApplicationContext wac;
	
	protected MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
}
