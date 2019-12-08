package com.github.jxen.measure.nonsi;

import static com.github.jxen.measure.nonsi.ImperialUnits.FAHRENHEIT;
import static com.github.jxen.measure.nonsi.ImperialUnits.RANKINE;
import static com.github.jxen.measure.unit.MetricUnits.KELVIN;
import static com.github.jxen.measure.unit.MiscUnits.CELSIUS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.jxen.measure.quantity.Quantities;
import org.junit.jupiter.api.Test;

public class ImperialUnitsTest {

	@Test
	void testRankine() {
		assertEquals(Quantities.of(100.0, KELVIN), Quantities.of(180, RANKINE).to(KELVIN));
	}

	@Test
	void testFahrenheitCase1() {
		assertEquals(0, Quantities.of(32, FAHRENHEIT).to(CELSIUS).getValue().doubleValue(), 1e-10);
	}

	@Test
	void testFahrenheitCase2() {
		assertEquals(100.0, Quantities.of(212, FAHRENHEIT).to(CELSIUS).getValue().doubleValue(), 1e-10);
	}
}
