package org.opencab.config;

import java.io.FileNotFoundException;

import org.apache.log4j.LogManager;
import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

// The new test runner
public class JUnit4ClassRunner extends SpringJUnit4ClassRunner {

  static {
    try {
    	
      LogManager.resetConfiguration();	
      Log4jConfigurer.initLogging( "src/test/resources/log4j-test.properties" );
      
    }
    catch( FileNotFoundException ex ) {
      System.err.println( "Cannot Initialize log4j" );
    }
  }

  public JUnit4ClassRunner( Class<?> clazz ) throws InitializationError {
    super( clazz );
  }
}
