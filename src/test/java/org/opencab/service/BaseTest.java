package org.opencab.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.opencab.config.BeanConfig;
import org.opencab.config.JUnit4ClassRunner;
import org.opencab.config.StandaloneDataConfig;
import org.opencab.db.model.AbstractEntity;
import org.opencab.db.model.Profile;
import org.opencab.db.model.User;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(JUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {
		StandaloneDataConfig.class, BeanConfig.class })
public abstract class BaseTest {

	protected void assertCreate(AbstractEntity entity) {
		Assert.assertNotNull(entity);
		Assert.assertNotNull(entity.getId());
	}

	protected User getUser() {

		
		Profile profile = new Profile("email", "passwordhash", 1, false,
				new Date(), null);
		User user  = new User("rajender", "singh", "saini", null, profile);
		profile.setUser(user);

		return user;
	}
}
