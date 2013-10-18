package org.opencab.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.opencab")
public class BeanConfig {
	private static final Logger logger = LoggerFactory
			.getLogger(AppConfig.class);

	public BeanConfig() {
		logger.debug("Setting up autoscaning for beans");
	}
}
