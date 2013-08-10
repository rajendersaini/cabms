package org.opencab.service;

import javax.annotation.Resource;

import org.opencab.db.model.Booking;
import org.opencab.db.repository.BookingRepos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl extends GenericServiceImpl<Booking> {

	@Resource
	private BookingRepos repos;
	@Override
	protected JpaRepository<Booking, Long> getRepos() {
		return repos;
	}

}
