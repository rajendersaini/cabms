package org.opencab.service;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.opencab.db.model.User;
import org.opencab.exception.EntityNotFoundException;

public class TestUserServiceImpl extends BaseTest {

	@Resource
	private UserServiceImpl userService;

	@Before
	public void setUp() {

	}

	private User getUser() {
		return new User("rajender", "singh", "saini", null);
	}

	@Test
	public void testCreate() throws EntityNotFoundException {
		User u = userService.create(getUser());
		assertCreate(u);

		// now delete user
		userService.delete(u.getId());
	}
}
