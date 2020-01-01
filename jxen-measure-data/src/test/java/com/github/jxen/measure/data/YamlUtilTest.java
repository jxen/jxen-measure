package com.github.jxen.measure.data;

import static com.github.jxen.measure.system.MetricUnits.METER;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import javax.measure.MeasurementException;
import org.junit.jupiter.api.Test;

class YamlUtilTest {

	@Test
	void testFillEmpty() {
		assertDoesNotThrow(() -> YamlUtil.fill(new HashMap<>(), YamlUtil.class, METER));
	}

	@Test
	void testFillFailure() {
		assertThrows(MeasurementException.class, () -> YamlUtil.fill(new HashMap<>(), YamlUtilTest.class, METER));
	}
}
