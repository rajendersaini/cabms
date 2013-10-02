package org.opencab.service;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.opencab.db.model.Address;
import org.opencab.db.model.Booking;
import org.opencab.db.model.User;
import org.opencab.exception.EntityNotFoundException;

public class TestBookingServiceImpl extends BaseTest {

	@Resource
	private BookingServiceImpl bookingService;

	@Resource
	private UserServiceImpl userService;

	private User user = new User("gp", "k", "saini", null);

	@Before
	public void setup() {
		userService.create(user);
	}

	@Test
	public void testCreate() throws EntityNotFoundException {

		Booking booking = new Booking();

		Address start = new Address("2443 w bryn mawr ave ", "apt-gg",
				"chicago", "il", "USA", "60659");
		Address end = new Address("4600 n clarendon ave ", "apt-307",
				"chicago", "il", "USA", "60640");

		booking.setStart(start);
		booking.setEnd(end);
		booking.setBookedBy(user);
		Booking bookingSaved = bookingService.create(booking);
		Assert.assertNotNull(bookingSaved);
		Assert.assertEquals("60640", bookingSaved.getEnd().getZip());

		Assert.assertNotNull(bookingSaved.getRef());
		Assert.assertEquals(13, bookingSaved.getRef().length());
		
		bookingService.delete(bookingSaved.getId());

	}

	@After
	public void tearDown() throws EntityNotFoundException {
		userService.delete(user.getId());
	}

}
