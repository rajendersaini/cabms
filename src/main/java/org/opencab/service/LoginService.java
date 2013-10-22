package org.opencab.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



public class LoginService implements UserDetailsService {
	
	

	@Override
	public UserDetails loadUserByUsername(String userEmail)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
