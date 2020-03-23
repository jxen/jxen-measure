package com.github.jxen.currency;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.jxen.math.rational.Rational;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CurrencyAmountTest {

	@Test
	void testZero() {
		CurrencyAmount amount = new CurrencyAmount(0, CurrencyUnit.SYSTEM_UNIT);
		assertEquals(0, amount.getValue());
	}

	@Test
	void testRounded() {
		CurrencyAmount amount = new CurrencyAmount(1.5, CurrencyUnit.SYSTEM_UNIT);
		assertEquals(2.0, amount.getValue());
	}

	@Test
	void testFractionUnitBigDecimal() {
		BigDecimal value = BigDecimal.valueOf(3.5);
		CurrencyUnit fractionUnit = new CurrencyUnit("", 1, new Rational(1, 960));
		CurrencyAmount amount = new CurrencyAmount(value, fractionUnit);
		assertEquals(value, amount.getValue());
	}
}
