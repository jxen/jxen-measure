package com.github.jxen.measure.data;

import static com.github.jxen.measure.system.MetricUnits.METER;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class YamlUtilTest {

	@Test
	void testFillEmpty() {
		assertDoesNotThrow(() -> YamlUtil.fill(YamlUtil.class, METER));
	}

	@Test
	void testFillFailure() {
		assertEquals(0, YamlUtil.fill(YamlUtilTest.class, METER).size());
	}
}
