package com.github.jxen.measure.format;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.jxen.measure.unit.MetricPrefix;
import com.github.jxen.measure.unit.MetricUnits;
import java.util.Locale;
import javax.measure.format.UnitFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DefaultUnitFormatTest {

	private final UnitFormat format = new DefaultUnitFormat();

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
		assertEquals("m", format.format(MetricUnits.METER));
	}

	@Test
	void testFormatKilometer() {
		assertEquals("km", format.format(MetricPrefix.kilo(MetricUnits.METER)));
	}

	@Test
	void testLabel() {
		assertThrows(UnsupportedOperationException.class, () -> format.label(null, null));
	}

	@Test
	void testLocaleSensitive() {
		assertTrue(format.isLocaleSensitive());
	}

	@Test
	void testParse2() {
		assertThrows(UnsupportedOperationException.class, () -> format.parse(null, null));
	}

	@Test
	void testParse() {
		assertThrows(UnsupportedOperationException.class, () -> format.parse(null));
	}
}
