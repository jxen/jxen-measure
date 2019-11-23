package com.github.jxen.measure.format;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DefaultLocaleAdapterTest {

	private LocaleAdapter adapter = new DefaultLocaleAdapter();

	@Test
	void testSingle() {
		assertEquals("", adapter.getSuffix(1));
	}

	@Test
	void testPlural() {
		assertEquals(".plural", adapter.getSuffix(2));
	}
}
