package org.opencab.util;

import junit.framework.Assert;

import org.junit.Test;
import org.opencab.service.BaseTest;

public class TestRefgenerator extends BaseTest {

	@Test
	public void testGenRef() {

		String ref = RefGenerator.getInstance().genRef();

		Assert.assertNotNull(ref);
		Assert.assertEquals(13, ref.length());

	}
}
