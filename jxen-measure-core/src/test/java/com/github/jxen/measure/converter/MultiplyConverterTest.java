package com.github.jxen.measure.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.jxen.math.rational.Rational;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import javax.measure.UnitConverter;
import org.junit.jupiter.api.Test;

class MultiplyConverterTest {

	@Test
	void testCreateFailureNull() {
		assertThrows(IllegalArgumentException.class, () -> Converters.fromFactor(null));
	}

	@Test
	void testCreateFailureZero() {
		assertThrows(IllegalArgumentException.class, () -> Converters.fromFactor(0));
	}

	@Test
	void testIdentity() {
		assertEquals(Converters.IDENTITY, Converters.fromFactor(1));
	}

	@Test
	void testNotIdentity() {
		assertFalse(Converters.fromFactor(2).isIdentity());
	}

	@Test
	void testLinear() {
		assertTrue(Converters.fromFactor(2).isLinear());
	}

	@Test
	void testInverse() {
		UnitConverter converter = Converters.fromFactor(2).inverse();
		assertEquals(1.0, converter.convert(2.0));
	}

	@Test
	void testConvertNumber() {
		UnitConverter converter = Converters.fromFactor(2);
		assertEquals(BigDecimal.valueOf(2.0), converter.convert(BigDecimal.ONE));
	}

	@Test
	void testConvertDouble() {
		UnitConverter converter = Converters.fromFactor(2);
		assertEquals(2.0, converter.convert(1.0));
	}

	@Test
	void testConcatenateCase1() {
		UnitConverter converter = Converters.fromFactor(2).concatenate(Converters.fromFactor(2));
		assertEquals(4.0, converter.convert(1.0));
	}

	@Test
	void testConcatenateCase2() {
		UnitConverter converter = Converters.fromFactor(2).concatenate(Converters.fromFactor(0.5));
		assertEquals(Converters.IDENTITY, converter);
	}

	@Test
	void testConcatenateCase3() {
		UnitConverter converter = Converters.fromFactor(2).concatenate(Converters.IDENTITY);
		assertEquals(2.0, converter.convert(1.0));
	}

	@Test
	void testConcatenateCase4() {
		UnitConverter converter = Converters.fromFactor(2).concatenate(Converters.fromOffset(1));
		assertEquals(4.0, converter.convert(1.0));
	}

	@Test
	void testConversionSteps() {
		List<? extends UnitConverter> steps = Converters.fromFactor(2).getConversionSteps();
		assertEquals(Collections.singletonList(Converters.fromFactor(2)), steps);
	}

	@Test
	void testToString() {
		assertEquals("MultiplyConverter(2)", Converters.fromFactor(2).toString());
	}

	@Test
	void testEquals() {
		UnitConverter converter = Converters.fromFactor(2);
		assertEquals(converter, converter);
	}

	@Test
	void testNotEquals() {
		assertNotEquals(Converters.fromFactor(2), Converters.fromOffset(1));
	}
}
