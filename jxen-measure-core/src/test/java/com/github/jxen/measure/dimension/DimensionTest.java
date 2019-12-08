package com.github.jxen.measure.dimension;

import static com.github.jxen.measure.dimension.Dimensions.LENGTH;
import static com.github.jxen.measure.dimension.Dimensions.TIME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import javax.measure.Dimension;
import org.junit.jupiter.api.Test;

class DimensionTest {

	@Test
	void testBaseDimensionCase1() {
		assertEquals(Collections.singleton(LENGTH), LENGTH.getBaseDimensions().keySet());
	}

	@Test
	void testBaseDimensionCase2() {
		assertNotEquals(Collections.singleton(LENGTH), Dimensions.MASS.getBaseDimensions().keySet());
	}

	@Test
	void testDimensionDivide() {
		Dimension dimension = LENGTH.divide(Dimensions.TIME);
		Map<BaseDimension, Integer> expected = new EnumMap<>(BaseDimension.class);
		expected.put(BaseDimension.LENGTH, 1);
		expected.put(BaseDimension.TIME, -1);
		assertEquals(expected, dimension.getBaseDimensions());
	}

	@Test
	void testDimensionRootCase1() {
		assertThrows(ArithmeticException.class, () -> LENGTH.root(2));
	}

	@Test
	void testDimensionRootCase2() {
		assertThrows(ArithmeticException.class, () -> LENGTH.pow(2).root(3));
	}

	@Test
	void testNotEqualsDifferent() {
		assertNotEquals("", LENGTH);
	}

	@Test
	void testEquals() {
		assertEquals(LENGTH.pow(2), LENGTH.multiply(LENGTH));
	}

	@Test
	void testNotEquals() {
		assertNotEquals(LENGTH.multiply(TIME), LENGTH.divide(TIME));
	}
}
