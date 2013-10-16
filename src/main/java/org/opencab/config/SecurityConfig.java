package org.opencab.config;

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

	@Override
	protected void registerAuthentication(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("pass")
				.roles("USER");
	}


	@Bean
	public BasicAuthenticationEntryPoint entryPoint() {
	    BasicAuthenticationEntryPoint basicAuthEntryPoint = new BasicAuthenticationEntryPoint();
	    basicAuthEntryPoint.setRealmName("CABMS Realm");
	    return basicAuthEntryPoint;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	    http
	        .exceptionHandling()
	            .authenticationEntryPoint(entryPoint())
	            .and()
	        .authorizeUrls().antMatchers("/css/**").permitAll()
			.antMatchers("/images/**").permitAll().antMatchers("/js/**")
			.permitAll()
	            .anyRequest().authenticated()
	            .and()
	        .httpBasic();       
	}
	
	
	
}