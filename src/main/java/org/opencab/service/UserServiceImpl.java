package org.opencab.service;

import javax.annotation.Resource;

import org.opencab.db.model.User;
import org.opencab.db.repository.UserRepos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<User> {

	@Resource
	private UserRepos repos;

	@Override
	protected JpaRepository<User, Long> getRepos() {
		return repos;
	}

}
