package org.opencab.config;

import javax.servlet.ServletContext;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;


public class SecurityWebApplicationInitializer extends
		AbstractSecurityWebApplicationInitializer {

	@Override
	protected void afterSpringSecurityFilterChain(ServletContext servletContext) {
		System.out
				.println("*************** this is called after spring security filter chain "
						+ "*************************");
		super.afterSpringSecurityFilterChain(servletContext);
	}

}
