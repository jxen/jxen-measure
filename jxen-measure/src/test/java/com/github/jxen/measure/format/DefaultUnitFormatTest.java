package com.github.jxen.measure.format;

import static com.github.jxen.measure.unit.MechanicalUnits.METER_PER_SECOND;
import static com.github.jxen.measure.unit.MechanicalUnits.METER_PER_SECOND_SQUARED;
import static com.github.jxen.measure.unit.MechanicalUnits.SQUARE_METER;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.jxen.measure.unit.MetricPrefix;
import com.github.jxen.measure.unit.MetricUnits;
import java.util.Locale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DefaultUnitFormatTest {

	@BeforeEach
	void setUp() {
		Locale.setDefault(Locale.US);
	}

	@Test
	void testCreate() {
		assertDoesNotThrow(() -> new DefaultUnitFormat("empty"));
	}

	@Test
	void testFormatMeter() {
		assertEquals("m", new DefaultUnitFormat().format(MetricUnits.METER));
	}

	@Test
	void testFormatKilometer() {
		assertEquals("km", new DefaultUnitFormat().format(MetricPrefix.kilo(MetricUnits.METER)));
	}

	@Test
	void testFormatSquareMeter() {
		assertEquals("m\u00B2", new DefaultUnitFormat().format(SQUARE_METER));
	}

	@Test
	void testFormatMeterPerSecond() {
		assertEquals("m/s", new DefaultUnitFormat().format(METER_PER_SECOND));
	}

	@Test
	void testFormatMeterPerSquareSecond() {
		assertEquals("m/s\u00B2", new DefaultUnitFormat().format(METER_PER_SECOND_SQUARED));
	}

	@Test
	void testLabel() {
		assertThrows(UnsupportedOperationException.class, () -> new DefaultUnitFormat().label(null, null));
	}

	@Test
	void testLocaleSensitive() {
		assertTrue(new DefaultUnitFormat().isLocaleSensitive());
	}

	@Test
	void testParse2() {
		assertThrows(UnsupportedOperationException.class, () -> new DefaultUnitFormat().parse(null, null));
	}

	@Test
	void testParse() {
		assertThrows(UnsupportedOperationException.class, () -> new DefaultUnitFormat().parse(null));
	}
}
