package com.github.jxen.measure.spi.adapter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.jxen.measure.format.LocaleAdapter;
import org.junit.jupiter.api.Test;

class NonSiRuLocaleAdapterTest {

	private LocaleAdapter adapter = new NonSiRuLocaleAdapter();

	@Test
	void testIsFeminineCase1() {
		assertFalse(adapter.isFeminine("meter"));
	}

	@Test
	void testIsFeminineCase2() {
		assertTrue(adapter.isFeminine("second"));
	}

	@Test
	void testIsFeminineCase3() {
		assertTrue(adapter.isFeminine("ounce"));
	}
}
