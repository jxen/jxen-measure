package com.github.jxen.measure.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.jxen.math.rational.Rational;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.measure.UnitConverter;
import org.junit.jupiter.api.Test;

class CombineConverterTest {

	@Test
	void testNotIdentity() {
		assertFalse(Converters.fromOffset(1).concatenate(Converters.fromFactor(2)).isIdentity());
	}

	@Test
	void testLinearCase1() {
		assertFalse(Converters.fromOffset(1).concatenate(Converters.fromFactor(2)).isLinear());
	}

	@Test
	void testLinearCase2() {
		assertFalse(Converters.fromFactor(2).concatenate(Converters.fromOffset(1)).isLinear());
	}

	@Test
	void testInverse() {
		UnitConverter converter = Converters.fromOffset(1).concatenate(Converters.fromFactor(2)).inverse();
		assertEquals(0.5, converter.convert(2.0));
	}

	@Test
	void testConvertNumber() {
		UnitConverter converter = Converters.fromOffset(1).concatenate(Converters.fromFactor(2));
		assertEquals(new Rational(3), converter.convert(Rational.ONE));
	}

	@Test
	void testConvertDouble() {
		UnitConverter converter = Converters.fromOffset(1).concatenate(Converters.fromFactor(2));
		assertEquals(3.0, converter.convert(1.0));
	}

	@Test
	void testConversionSteps() {
		UnitConverter converter = Converters.fromOffset(1).concatenate(Converters.fromFactor(2));
		List<? extends UnitConverter> steps = converter.getConversionSteps();
		assertEquals(Arrays.asList(Converters.fromOffset(1), Converters.fromFactor(2)), steps);
	}

	@Test
	void testToString() {
		assertEquals("CombineConverter(AddConverter(1),MultiplyConverter(2))",
				Converters.fromOffset(1).concatenate(Converters.fromFactor(2)).toString());
	}

	@Test
	void testEqualsAndHashCode() {
		Map<UnitConverter, String> map1 = new LinkedHashMap<>();
		map1.put(Converters.fromOffset(1).concatenate(Converters.fromFactor(2)), "a");
		map1.put(Converters.fromFactor(2), "b");
		Map<UnitConverter, String> map2 = new LinkedHashMap<>();
		map2.put(Converters.fromOffset(1).concatenate(Converters.fromFactor(2)), "a");
		map2.put(Converters.fromOffset(1), "b");
		assertNotEquals(map1, map2);
	}

	@Test
	void testEquals() {
		UnitConverter converter = Converters.fromOffset(1).concatenate(Converters.fromFactor(2));
		assertEquals(converter, converter);
	}

	@Test
	void testNotEqualsCase1() {
		assertNotEquals(Converters.fromOffset(1).concatenate(Converters.fromFactor(2)), Converters.fromOffset(1));
	}

	@Test
	void testNotEqualsCase2() {
		assertNotEquals(Converters.fromOffset(1).concatenate(Converters.fromFactor(2)),
				Converters.fromOffset(1).concatenate(Converters.fromFactor(3)));
	}

	@Test
	void testNotEqualsCase3() {
		assertNotEquals(Converters.fromOffset(1).concatenate(Converters.fromFactor(2)),
				Converters.fromOffset(2).concatenate(Converters.fromFactor(2)));
	}

	@Test
	void testNotEqualsCase4() {
		assertNotEquals(Converters.fromOffset(1).concatenate(Converters.fromFactor(2)),
				Converters.fromOffset(2).concatenate(Converters.fromFactor(3)));
	}
}
