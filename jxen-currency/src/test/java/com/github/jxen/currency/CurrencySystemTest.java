package com.github.jxen.currency;

import static com.github.jxen.currency.CurrencyUnit.SYSTEM_UNIT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.measure.MeasurementException;
import org.junit.jupiter.api.Test;

class CurrencySystemTest {

	private final CurrencySystem system = new CurrencySystem(SYSTEM_UNIT,
			new CurrencyUnit("test", SYSTEM_UNIT, 0.5));

	@Test
	void testGetBaseUnit() {
		assertEquals(SYSTEM_UNIT, system.getBaseUnit());
	}

	@Test
	void testForCode() {
		assertEquals("test", system.forCode("test").getName());
	}

	@Test
	void testForCodeFailure() {
		assertThrows(MeasurementException.class, () -> system.forCode("unknown"));
	}
}
