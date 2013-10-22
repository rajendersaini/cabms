package org.opencab.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Order(1)
public class WebAppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	private static final Logger logger = LoggerFactory
			.getLogger(WebAppInitializer.class);

	private static final String ACITVE_PROFILE = "spring.profiles.active";

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {

		logger.info("Setting active profile as - {0}",
				"prod");
		servletContext.setInitParameter(ACITVE_PROFILE, "prod");
		super.onStartup(servletContext);
	}


	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { AppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/*" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { SecurityConfig.class };

	}

}
