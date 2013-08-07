package org.opencab.config;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityConfig;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

@Configuration
@EnableWebMvc
@Profile("prod")
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {
	JndiDataConfig.class, BeanConfig.class })
public class AppConfig implements ApplicationContextAware {
	@Resource
	private Environment env;

	private ApplicationContext context;

	@Bean
	public VelocityConfig velocityConfig() {
		VelocityConfigurer cfg = new VelocityConfigurer();
		cfg.setResourceLoaderPath("/WEB-INF/velocity");
		cfg.setConfigLocation(context
				.getResource("classpath:velocity.properties"));
		return cfg;
	}

	@Bean
	public ViewResolver viewResolver() {
		VelocityViewResolver resolver = new VelocityViewResolver();
		resolver.setViewClass(MyVelocityToolboxView.class);
		resolver.setSuffix(".vm");
		return resolver;
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer cfg = new TilesConfigurer();
		cfg.setTilesInitializer(new VelocityTilesInitializer(velocityConfig()));
		return cfg;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = applicationContext;

	}

}
