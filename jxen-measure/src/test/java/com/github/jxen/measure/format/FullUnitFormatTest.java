package com.github.jxen.measure.format;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.jxen.measure.unit.MetricPrefix;
import com.github.jxen.measure.unit.MetricUnits;
import java.util.Locale;
import javax.measure.format.UnitFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FullUnitFormatTest {

	private final UnitFormat format = new FullUnitFormat();

	@BeforeEach
	void setUp() {
		Locale.setDefault(Locale.US);
	}

	@Test
	void testFormatMeter() {
		assertEquals("meter", format.format(MetricUnits.METER));
	}

	@Test
	void testFormatKilometer() {
		assertEquals("kilometer", format.format(MetricPrefix.kilo(MetricUnits.METER)));
	}
}
