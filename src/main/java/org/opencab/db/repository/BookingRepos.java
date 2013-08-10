package org.opencab.db.repository;

import org.opencab.db.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepos extends JpaRepository<Booking, Long> {

}
