package org.opencab.service;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
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
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {
		StandaloneDataConfig.class, BeanConfig.class })
public class TestVehicleServiceImpl {

	@Resource
	private VehicleServiceImpl vehicleService;

	private Vehicle vehForDelete;
	private Vehicle vehForGet;

	@Before
	public void setUp() {
		vehForDelete = vehicleService.create(getVehicle());
		vehForGet = vehicleService.create(getVehicle());

	}

	@After
	public void tearDown() throws EntityNotFoundException {
		vehicleService.delete(vehForGet.getId());
	}

	private Vehicle getVehicle() {
		Vehicle veh = new Vehicle();

		veh.setCapacity(1);
		veh.setMake("bmw");
		veh.setModel(new Date("03/03/2012"));
		return veh;
	}

	@Test
	public void testCreate() throws EntityNotFoundException {

		Vehicle veh = getVehicle();
		veh = vehicleService.create(veh);
		Assert.assertNotNull(veh.getId());
		// delete
		vehicleService.delete(veh.getId());

	}

	@Test
	public void testDelete() throws EntityNotFoundException {
		vehicleService.delete(vehForDelete.getId());
		
		Vehicle veh = vehicleService.findById(vehForDelete.getId());
		
		Assert.assertNull(veh);

	}

	@Test
	public void testGet() {
		Vehicle veh = vehicleService.findById(vehForGet.getId());
		Assert.assertEquals("Object found should be same ", vehForGet.getId(),
				veh.getId());
	}

}
