package org.opencab.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.opencab.db.model.User;
import org.opencab.exception.EntityNotFoundException;

public class TestUserServiceImpl extends BaseTest {
	@Resource
	private UserServiceImpl userService;
	@Test
	public void testCreate() throws EntityNotFoundException {
		User u = userService.create(getUser());
		assertCreate(u);

		// now delete user
		userService.delete(u.getId());
	}
}
