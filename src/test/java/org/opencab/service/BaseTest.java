package org.opencab.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.annotations.Synchronize;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.opencab.config.BeanConfig;
import org.opencab.config.JUnit4ClassRunner;
import org.opencab.config.StandaloneDataConfig;
import org.opencab.db.model.AbstractEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
}
