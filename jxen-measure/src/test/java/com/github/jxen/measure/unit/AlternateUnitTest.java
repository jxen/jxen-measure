package com.github.jxen.measure.unit;

import static com.github.jxen.measure.unit.MetricUnits.METER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.jxen.measure.dimension.Dimensions;
import java.util.HashMap;
import java.util.Map;
import javax.measure.Unit;
import javax.measure.quantity.Length;
import org.junit.jupiter.api.Test;

class AlternateUnitTest {

	@Test
	void testGetDimension() {
		assertEquals(Dimensions.LENGTH, METER.alternate("alt").getDimension());
	}

	@Test
	void testGetBaseUnit() {
		Map<Unit<Length>, Integer> expected = new HashMap<>();
		expected.put(METER, 1);
		assertEquals(expected, METER.alternate("alt").getBaseUnits());
	}

	@Test
	void testGetSystemUnit() {
		assertEquals(METER, METER.alternate("alt").getSystemUnit());
	}

	@Test
	void testParent() {
		assertTrue(METER.alternate("alt").alternate("another") instanceof AlternateUnit);
	}
}
