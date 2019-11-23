package com.github.jxen.measure.format;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RuLocaleAdapterTest {

	private LocaleAdapter adapter = new RuLocaleAdapter();

	@Test
	void testSingle() {
		assertEquals("", adapter.getSuffix(1));
	}

	@Test
	void testPart() {
		assertEquals(".part", adapter.getSuffix(1.5));
	}

	@Test
	void testPlural() {
		assertEquals(".plural", adapter.getSuffix(2));
	}

	@Test
	void testPlural22() {
		assertEquals(".plural", adapter.getSuffix(22));
	}

	@Test
	void testPlural5() {
		assertEquals(".plural5", adapter.getSuffix(5));
	}

	@Test
	void testPlural11() {
		assertEquals(".plural5", adapter.getSuffix(11));
	}

	@Test
	void testPlural50() {
		assertEquals(".plural5", adapter.getSuffix(50));
	}
}
