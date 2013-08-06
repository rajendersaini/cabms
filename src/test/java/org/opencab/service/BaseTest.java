package org.opencab.service;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.open.config.StandaloneDataConfig;
import org.opencab.config.BeanConfig;
import org.opencab.db.model.AbstractEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {
		StandaloneDataConfig.class, BeanConfig.class })
public abstract class BaseTest {

	protected void assertCreate(AbstractEntity entity) {
		Assert.assertNotNull(entity);
		Assert.assertNotNull(entity.getId());
	}
}
