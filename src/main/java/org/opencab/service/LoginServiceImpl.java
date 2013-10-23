package org.opencab.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.opencab.db.model.Profile;
import org.opencab.db.repository.ProfileRepos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends GenericServiceImpl<Profile> implements
		UserDetailsService {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginServiceImpl.class);

	@Resource
	private ProfileRepos repos;

	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {

		Profile profile = repos.findUserProfileByEmail(email);
		if (null == profile) {

			logger.warn("User with email - {} does not exists", email);
			throw new UsernameNotFoundException("User does not exist");

		}

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new GrantedAuthority() {
			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
				return "ADMIN";
			}
		});

		return new User(profile.getEmail(), profile.getPasswordhash(),
				authorities);
	}

	@Override
	protected JpaRepository<Profile, Long> getRepos() {
		return repos;
	}

}
