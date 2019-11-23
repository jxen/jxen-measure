package com.github.jxen.measure.format;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.jxen.measure.unit.MetricPrefix;
import com.github.jxen.measure.unit.MetricUnits;
import java.util.Locale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FullUnitFormatTest {

	@BeforeEach
	void setUp() {
		Locale.setDefault(Locale.US);
	}

	@Test
	void testFormatMeter() {
		assertEquals("meter", new FullUnitFormat().format(MetricUnits.METER));
	}

	@Test
	void testFormatKilometer() {
		assertEquals("kilometer", new FullUnitFormat().format(MetricPrefix.kilo(MetricUnits.METER)));
	}
}
