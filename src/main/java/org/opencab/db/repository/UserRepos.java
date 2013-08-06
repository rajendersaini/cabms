package org.opencab.db.repository;

import javax.annotation.Resource;

import org.opencab.db.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Resource
public interface UserRepos extends JpaRepository<User, Long> {

}
