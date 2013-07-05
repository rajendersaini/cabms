package org.opencab.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository<T> extends JpaRepository<T, Long> {
}
