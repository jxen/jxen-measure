package com.github.jxen.measure.quantity.impl;

import static com.github.jxen.measure.system.MetricUnits.METER;
import static com.github.jxen.measure.unit.MetricPrefix.kilo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.jxen.math.rational.BigRational;
import com.github.jxen.math.rational.Rational;
import org.junit.jupiter.api.Test;

class QuantiesTest {

	@Test
	void testToDouble() {
		LengthAmount length = new LengthAmount(1.5, kilo(METER));
		assertEquals(1500.0, Quantities.toDouble(length, METER));
	}

	@Test
	void testToFloat() {
		LengthAmount length = new LengthAmount(1.5, kilo(METER));
		assertEquals(1500f, Quantities.toFloat(length, METER));
	}

	@Test
	void testToLong() {
		LengthAmount length = new LengthAmount(1.5, kilo(METER));
		assertEquals(1500L, Quantities.toLong(length, METER));
	}

	@Test
	void testToInt() {
		LengthAmount length = new LengthAmount(1.5, kilo(METER));
		assertEquals(1500, Quantities.toInt(length, METER));
	}

	@Test
	void testToRational() {
		LengthAmount length = new LengthAmount(1.5, kilo(METER));
		assertEquals(Rational.valueOf(1500), Quantities.toRational(length, METER));
	}

	@Test
	void testToBigRational() {
		LengthAmount length = new LengthAmount(1.5, kilo(METER));
		assertEquals(BigRational.valueOf(1500), Quantities.toBigRational(length, METER));
	}
}
