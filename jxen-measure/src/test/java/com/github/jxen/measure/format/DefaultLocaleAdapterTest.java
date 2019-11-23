package com.github.jxen.measure.format;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DefaultLocaleAdapterTest {

	private LocaleAdapter adapter = new DefaultLocaleAdapter();

	@Test
	void testNameHalf() {
		assertEquals("name", adapter.name("name", 0.5));
	}

	@Test
	void testNameSingle() {
		assertEquals("name", adapter.name("name", 1));
	}

	@Test
	void testNamePlural() {
		assertEquals("name.plural", adapter.name("name", 2));
	}

	@Test
	void testSuffixHalf() {
		assertEquals("suffix", adapter.suffix("suffix", "name", 0.5));
	}

	@Test
	void testSuffixSingle() {
		assertEquals("suffix", adapter.suffix("suffix", "name", 1));
	}

	@Test
	void testSuffixPlural() {
		assertEquals("suffix", adapter.suffix("suffix", "name", 2));
	}
}
