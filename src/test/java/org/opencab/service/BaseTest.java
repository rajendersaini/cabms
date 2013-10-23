package org.opencab.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.opencab.config.BeanConfig;
import org.opencab.config.JUnit4ClassRunner;
import org.opencab.config.StandaloneDataConfig;
import org.opencab.db.model.AbstractEntity;
import org.opencab.db.model.Profile;
import org.opencab.db.model.Role;
import org.opencab.db.model.User;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(JUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = { StandaloneDataConfig.class, BeanConfig.class })
@WebAppConfiguration
public abstract class BaseTest {

	private MockMvc mockMvc;

	protected static final String testEmail = "raj@test.com";

	protected void assertCreate(AbstractEntity entity) {
		Assert.assertNotNull(entity);
		Assert.assertNotNull(entity.getId());
	}

	protected User getUser() {

		Profile profile = getProfile();
		Role role = new Role("ADMIN");
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		User user = new User("rajender", "singh", "saini", null, profile, roles);
		profile.setUser(user);
		role.setUser(user);
		return user;
	}

	protected Profile getProfile() {
		return new Profile(testEmail, "passwordhash", 1, false, new Date(),
				null);
	}
}
