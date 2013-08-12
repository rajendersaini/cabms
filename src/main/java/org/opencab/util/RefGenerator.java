package org.opencab.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RefGenerator {

	private static final Logger logger = LoggerFactory
			.getLogger(RefGenerator.class);

	private static RefGenerator instance = new RefGenerator();

	private DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

	private RefGenerator() {
	}

	public static RefGenerator getInstance() {
		return instance;
	}

	public String genRef() {

		String ref = dateFormat.format(new Date()) + "-"
				+ String.format("%04d", new Random().nextInt(9999));

		logger.debug("Generated ref - " + ref);
		return ref;
	}

}
