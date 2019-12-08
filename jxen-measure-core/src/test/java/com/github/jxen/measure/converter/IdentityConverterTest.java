package com.github.jxen.measure.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.jxen.math.rational.Rational;
import java.util.Collections;
import java.util.List;
import javax.measure.UnitConverter;
import org.junit.jupiter.api.Test;

class IdentityConverterTest {

	@Test
	void testIdentity() {
		assertTrue(Converters.IDENTITY.isIdentity());
	}

	@Test
	void testLinear() {
		assertTrue(Converters.IDENTITY.isLinear());
	}

	@Test
	void testInverse() {
		UnitConverter converter = Converters.IDENTITY.inverse();
		assertEquals(Converters.IDENTITY, converter);
	}

	@Test
	void testConvertNumber() {
		UnitConverter converter = Converters.IDENTITY;
		assertEquals(Rational.ONE, converter.convert(Rational.ONE));
	}

	@Test
	void testConvertDouble() {
		UnitConverter converter = Converters.IDENTITY;
		assertEquals(1.0, converter.convert(1.0));
	}

	@Test
	void testConcatenate() {
		UnitConverter converter = Converters.IDENTITY.concatenate(Converters.fromOffset(1));
		assertEquals(Converters.fromOffset(1), converter);
	}

	@Test
	void testConversionSteps() {
		List<? extends UnitConverter> steps = Converters.IDENTITY.getConversionSteps();
		assertEquals(Collections.singletonList(Converters.IDENTITY), steps);
	}
}
