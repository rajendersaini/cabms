package org.opencab.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityConfig;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("org.opencab")
@Profile("prod")
public class AppConfig extends WebMvcConfigurerAdapter implements
		ApplicationContextAware {

	private static final Logger logger = LoggerFactory
			.getLogger(AppConfig.class);

	@Resource
	private Environment env;

	private ApplicationContext context;

	@Bean
	public BeanNameViewResolver beanViewResolver() {
		BeanNameViewResolver resolver = new BeanNameViewResolver();
		resolver.setOrder(1);
		return resolver;
	}

	@Bean
	public MarshallingHttpMessageConverter marshallingMessageConverter() {
		MarshallingHttpMessageConverter converter = new MarshallingHttpMessageConverter(
				jaxb2Marshaller(), jaxb2Marshaller());
		List<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(MediaType.APPLICATION_XML);
		converter.setSupportedMediaTypes(mediaTypes);
		return converter;
	}

	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan(new String[] { "org.opencab.bean.*" });
		return marshaller;
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();

		converters.add(stringHttpMessageConverter());
		converters.add(marshallingJsonConverter());
		converters.add(marshallingMessageConverter());
		restTemplate.setMessageConverters(converters);

		return restTemplate;
	}

	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		return new StringHttpMessageConverter();
	}

	@Bean
	public MappingJacksonHttpMessageConverter marshallingJsonConverter() {
		List<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(MediaType.APPLICATION_JSON);
		MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
		converter.setSupportedMediaTypes(mediaTypes);
		return converter;
	}

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

    @Bean
    public ViewResolver contentNegotiatingViewResolver(
            ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();
        viewResolvers.add(beanViewResolver());
        viewResolvers.add(velocityViewResolver());
        resolver.setViewResolvers(viewResolvers);
        return resolver;
    }	
	public ViewResolver velocityViewResolver() {

		logger.debug("Setting up velocity view resolver");

		VelocityViewResolver resolver = new VelocityViewResolver();
		resolver.setViewClass(MyVelocityToolboxView.class);
		resolver.setSuffix(".vm");
		resolver.setExposeSpringMacroHelpers(true);
		return resolver;
	}
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
    }
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer cfg = new TilesConfigurer();
		cfg.setTilesInitializer(new VelocityTilesInitializer(velocityConfig()));
		return cfg;
	}
	
    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.ignoreAcceptHeader(true);
        Map<String, MediaType> mediaTypes = new HashMap<String, MediaType>();
        mediaTypes.put("json", MediaType.APPLICATION_JSON);
        mediaTypes.put("xml", MediaType.APPLICATION_XML);
        mediaTypes.put("xml2", MediaType.TEXT_XML);
        mediaTypes.put("xhtml", MediaType.APPLICATION_XHTML_XML);
        mediaTypes.put("html", MediaType.TEXT_HTML);
        configurer.mediaTypes(mediaTypes);
        configurer.defaultContentType(MediaType.TEXT_HTML);
    }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = applicationContext;

	}

}
