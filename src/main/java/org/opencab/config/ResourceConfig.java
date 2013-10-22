package org.opencab.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@PropertySource("classpath:app.properties")
public class ResourceConfig {

	private static final Logger logger = LoggerFactory
			.getLogger(ResourceConfig.class);
	public static final String RESOURCE_PATH_MATCHER = "/resources/**";

	public static final String RESOURCE_PATH = "/WEB-INF/resources/";

	public static void addResourceHandlers(ResourceHandlerRegistry registry) {
		logger.debug("Configuring web resources");

		registry.addResourceHandler(RESOURCE_PATH_MATCHER)
				.addResourceLocations(RESOURCE_PATH).setCachePeriod(31556926);
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}

}
