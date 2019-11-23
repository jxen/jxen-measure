package com.github.jxen.measure.dimension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Collections;
import org.junit.jupiter.api.Test;

class DimensionTest {

	@Test
	void testBaseDimensionCase1() {
		assertEquals(Collections.singleton(Dimensions.LENGTH), Dimensions.LENGTH.getBaseDimensions().keySet());
	}

	@Test
	void testBaseDimensionCase2() {
		assertNotEquals(Collections.singleton(Dimensions.LENGTH), Dimensions.MASS.getBaseDimensions().keySet());
	}
}
