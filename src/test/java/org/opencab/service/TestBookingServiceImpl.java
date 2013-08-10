package org.opencab.service;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.opencab.db.model.Address;
import org.opencab.db.model.Booking;

public class TestBookingServiceImpl extends BaseTest {

	@Resource
	BookingServiceImpl bookingService;

	@Test
	public void testCreate() {

		Booking booking = new Booking();

		Address start = new Address("2443 w bryn mawr ave ", "apt-gg",
				"chicago", "il", "USA", "60659");
		Address end = new Address("4600 n clarendon ave ", "apt-307",
				"chicago", "il", "USA", "60640");

		booking.setStart(start);
		booking.setEnd(end);
		Booking bookingSaved = bookingService.create(booking);
		Assert.assertNotNull(bookingSaved);
		Assert.assertEquals("60640", bookingSaved.getEnd().getZip());

		Assert.assertNotNull(bookingSaved.getRef());
		Assert.assertEquals(13,bookingSaved.getRef().length());
		

	}

}
