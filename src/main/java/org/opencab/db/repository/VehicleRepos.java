package org.opencab.db.repository;

import javax.annotation.Resource;

import org.opencab.db.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

@Resource
public interface VehicleRepos extends JpaRepository<Vehicle, Long> {

}
