package com.github.jxen.measure.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SubstanceTest {

	@Test
	void testCode() {
		assertEquals("Au", Substance.GOLD.getCode());
	}

	@Test
	void testName() {
		assertEquals("gold", Substance.GOLD.getName());
	}
}
