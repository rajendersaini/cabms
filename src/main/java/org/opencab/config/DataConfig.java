package org.opencab.config;

import javax.sql.DataSource;

public interface DataConfig {
	public static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
	public static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
	public static final String PROPERTY_NAME_DATABASE_URL = "db.url";
	public static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";

	public static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	public static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	public static final String PROPERTY_NAME_HIBERNATE_HBM2DDL="hibernate.hbm2ddl.auto";
	public static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

	public DataSource dataSource();
}
