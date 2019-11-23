package com.github.jxen.currency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CurrencyAmountTest {

	@Test
	void testZero() {
		CurrencyAmount amount = CurrencyAmount.of(new CurrencyAmount(0, CurrencyUnit.SYSTEM_UNIT));
		Assertions.assertEquals(0, amount.getValue());
	}

	@Test
	void testRounded() {
		CurrencyAmount amount = CurrencyAmount.of(new CurrencyAmount(1.5, CurrencyUnit.SYSTEM_UNIT));
		Assertions.assertEquals(2.0, amount.getValue());
	}
}
