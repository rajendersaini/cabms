package org.opencab.service;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.opencab.db.model.Profile;
import org.springframework.security.core.userdetails.UserDetails;

public class TestLoginServiceImpl extends BaseTest {

	@Resource
	private LoginServiceImpl loginService;

	@Test
	public void testGetProfileByEmail() {

		Profile profile = getUser().getProfile();

		loginService.create(profile);

		UserDetails userdeails = loginService.loadUserByUsername(testEmail);

		Assert.assertNotNull(userdeails);

		Assert.assertEquals(testEmail, userdeails.getUsername());

	}

}
