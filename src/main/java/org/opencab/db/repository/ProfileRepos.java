package org.opencab.db.repository;

import org.opencab.db.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfileRepos extends JpaRepository<Profile, Long> {

	@Query("SELECT p FROM Profile p WHERE LOWER(p.email) = LOWER(:email)")
	Profile findUserProfileByEmail(@Param("email") String email);

}
