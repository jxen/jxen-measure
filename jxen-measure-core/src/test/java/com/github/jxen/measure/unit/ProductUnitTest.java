package com.github.jxen.measure.unit;

import static com.github.jxen.measure.converter.Converters.IDENTITY;
import static com.github.jxen.measure.unit.MeterUnits.SQUARE_METER;
import static com.github.jxen.measure.unit.MetricUnits.METER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.github.jxen.math.rational.BigRational;
import com.github.jxen.measure.converter.Converters;
import java.util.HashMap;
import java.util.Map;
import javax.measure.Unit;
import org.junit.jupiter.api.Test;

class ProductUnitTest {

	@Test
	void testGetBaseUnits() {
		Map<Unit<?>, Integer> expected = new HashMap<>();
		expected.put(METER, 2);
		assertEquals(expected, SQUARE_METER.getBaseUnits());
	}

	@Test
	void testToSystemUnit() {
		assertEquals(SQUARE_METER.getBaseUnits(), SQUARE_METER.toSystemUnit().getBaseUnits());
	}

	@Test
	void testGetSystemConverterCase1() {
		assertSame(IDENTITY, SQUARE_METER.getSystemConverter());
	}

	@Test
	void testGetSystemConverterCase2() {
		assertEquals(Converters.fromFactor(new BigRational(1, 1000000000)),
				((AbstractUnit<?>) MetricPrefix.nano(METER)).getSystemConverter());
	}
}
