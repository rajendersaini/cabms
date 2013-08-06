package org.opencab.service;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.open.config.StandaloneDataConfig;
import org.opencab.config.BeanConfig;
import org.opencab.db.model.Vehicle;
import org.opencab.exception.EntityNotFoundException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {StandaloneDataConfig.class, BeanConfig.class })
public class TestVehicleServiceImpl {

	@Resource
	private VehicleServiceImpl vehicleService;

	@Test
	public void testCreate() throws EntityNotFoundException {

		Vehicle veh = new Vehicle();

		veh.setCapacity(1);
		veh.setMake("bmw");
		veh.setModel(new Date("03/03/2012"));
		veh = vehicleService.create(veh);
		
		Assert.assertNotNull(veh.getId());
		
		// delete 
		
		vehicleService.delete(veh.getId());
		

	}

}
