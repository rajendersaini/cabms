package org.opencab.config;

import org.opencab.web.controller.LoginController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger logger = LoggerFactory
			.getLogger(JndiDataConfig.class);

	@Override
	protected void registerAuthentication(AuthenticationManagerBuilder auth)
			throws Exception {

		logger.debug("Registing auth provider");
		auth.inMemoryAuthentication().withUser("user").password("password")
				.roles("USER").and().withUser("admin").password("password")
				.roles("USER", "ADMIN");
	}

	@Bean
	public BasicAuthenticationEntryPoint entryPoint() {
		BasicAuthenticationEntryPoint basicAuthEntryPoint = new BasicAuthenticationEntryPoint();
		basicAuthEntryPoint.setRealmName("CABMS Realm");
		return basicAuthEntryPoint;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		logger.debug("configure http security");

		http.authorizeUrls()
				.antMatchers(LoginController.AUTHLOGIN,
						ResourceConfig.RESOURCE_PATH_MATCHER).permitAll()
				.anyRequest().authenticated().and().formLogin()
				.loginPage(LoginController.AUTHLOGIN);

	}

}