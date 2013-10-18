package org.opencab.config;

import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityConfig;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("org.opencab")
@Profile("prod")
@PropertySource("classpath:app.properties")
public class AppConfig extends WebMvcConfigurerAdapter implements
		ApplicationContextAware {

	private static final Logger logger = LoggerFactory
			.getLogger(AppConfig.class);

	@Resource
	private Environment env;

	private ApplicationContext context;

	@Bean
	public VelocityConfig velocityConfig() {

		logger.debug("Configuring velocity engine");

		VelocityConfigurer cfg = new VelocityConfigurer();

		cfg.setResourceLoaderPath("/WEB-INF/velocity");
		cfg.setConfigLocation(context
				.getResource("classpath:velocity.properties"));
		return cfg;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		logger.debug("Configuring web resources");
		ResourceConfig.addResourceHandlers(registry);
	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource rrbms = new ReloadableResourceBundleMessageSource();
		rrbms.setBasename("classpath:messages");

		return rrbms;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("language");

		return lci;
	}

	@Bean
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver clr = new CookieLocaleResolver();

		clr.setDefaultLocale(new Locale("en"));
		return clr;
	}

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public ViewResolver viewResolver() {

		logger.debug("Setting up velocity view resolver");

		VelocityViewResolver resolver = new VelocityViewResolver();
		resolver.setViewClass(MyVelocityToolboxView.class);
		resolver.setSuffix(".vm");
		resolver.setExposeSpringMacroHelpers(true);
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
