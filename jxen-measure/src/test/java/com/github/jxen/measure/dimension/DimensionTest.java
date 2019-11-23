package com.github.jxen.measure.dimension;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import org.junit.jupiter.api.Test;

class DimensionTest {

	@Test
	void testBaseDimension() {
		assertEquals(Collections.singleton(Dimensions.LENGTH), Dimensions.LENGTH.getBaseDimensions().keySet());
	}
}
