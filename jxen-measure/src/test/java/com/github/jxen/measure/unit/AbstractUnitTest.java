package com.github.jxen.measure.unit;

import static com.github.jxen.measure.converter.Converters.IDENTITY;
import static com.github.jxen.measure.converter.Converters.fromFactor;
import static com.github.jxen.measure.converter.Converters.fromOffset;
import static com.github.jxen.measure.unit.MetricUnits.METER;
import static com.github.jxen.measure.unit.MetricUnits.SECOND;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.measure.IncommensurableException;
import javax.measure.UnconvertibleException;
import javax.measure.Unit;
import javax.measure.quantity.Length;
import org.junit.jupiter.api.Test;

class AbstractUnitTest {

	@Test
	void testGetBaseUnit() {
		Map<Unit<Length>, Integer> expected = new HashMap<>();
		expected.put(METER, 1);
		assertEquals(expected, METER.getBaseUnits());
	}

	@Test
	void testCompatibleSame() {
		assertTrue(METER.isCompatible(METER));
	}

	@Test
	void testCompatibleTrue() {
		assertTrue(METER.isCompatible(MetricPrefix.milli(METER)));
	}

	@Test
	void testCompatibleFalse() {
		assertFalse(METER.isCompatible(SECOND));
	}

	@Test
	void testCompatibleOther() {
		assertFalse(METER.isCompatible(new UnitImpl()));
	}

	@Test
	void testAsType() {
		assertThrows(UnsupportedOperationException.class, () -> METER.asType(Length.class));
	}

	@Test
	void testGetConverterToCase1() {
		assertSame(IDENTITY, METER.getConverterTo(METER));
	}

	@Test
	void testGetConverterToCase2() {
		assertEquals(fromFactor(MetricPrefix.DEKA.getValue()), MetricPrefix.deka(METER).getConverterTo(METER));
	}

	@Test
	void testGetConverterToCase3() {
		assertThrows(UnconvertibleException.class, () -> METER.getConverterTo(new UnitImpl<>()));
	}

	@Test
	void testGetConverterToAnyFailure() {
		assertThrows(IncommensurableException.class, () -> METER.getConverterToAny(SECOND));
	}

	@Test
	void testGetConverterToAnySuccess() {
		assertDoesNotThrow(() -> METER.getConverterToAny(METER));
	}

	@Test
	void testShiftNumber() {
		Unit<Length> unit = METER.shift(BigDecimal.ONE);
		assertEquals(fromOffset(BigDecimal.ONE), unit.getConverterTo(METER));
	}

	@Test
	void testShiftDouble() {
		Unit<Length> unit = METER.shift(1.0);
		assertEquals(fromOffset(1.0), unit.getConverterTo(METER));
	}

	@Test
	void testMultiplyNumber() {
		Unit<Length> unit = METER.multiply(BigDecimal.TEN);
		assertEquals(fromFactor(BigDecimal.TEN), unit.getConverterTo(METER));
	}

	@Test
	void testMultiplyDouble() {
		Unit<Length> unit = METER.multiply(10.0);
		assertEquals(fromFactor(10.0), unit.getConverterTo(METER));
	}

	@Test
	void testMultiplyUnit() {
		assertThrows(UnsupportedOperationException.class, () -> METER.multiply(new UnitImpl<Length>()));
	}

	@Test
	void testDivideNumber() {
		Unit<Length> unit = METER.divide(BigDecimal.TEN);
		assertEquals(fromFactor(new BigDecimal("0.1")), unit.getConverterTo(METER));
	}

	@Test
	void testDivideDouble() {
		Unit<Length> unit = METER.divide(2.0);
		assertEquals(fromFactor(0.5), unit.getConverterTo(METER));
	}

	@Test
	void testToString() {
		Locale.setDefault(Locale.US);
		assertEquals("m", METER.toString());
	}
}
