package org.opencab.service;

import javax.annotation.Resource;

import org.opencab.db.model.Vehicle;
import org.opencab.db.repository.VehicleRepos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl extends GenericServiceImpl<Vehicle> {

	@Resource
	private VehicleRepos repos;

	@Override
	protected JpaRepository<Vehicle, Long> getRepos() {
		return repos;
	}
}
