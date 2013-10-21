package org.opencab.service;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.opencab.db.model.Vehicle;
import org.opencab.exception.EntityNotFoundException;

public class TestVehicleServiceImpl extends BaseTest {

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
		veh.setModel(new Date());
		return veh;
	}

	@Test
	public void testCreate() throws EntityNotFoundException {

		Vehicle veh = vehicleService.create(getVehicle());
		assertCreate(veh);
		// delete
		vehicleService.delete(veh.getId());

	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateWithNull() {

		vehicleService.create(null);
	}

	@Test(expected = EntityNotFoundException.class)
	public void testDeleteWithNegativeId() throws EntityNotFoundException {
		vehicleService.delete(new Long(-1));
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
