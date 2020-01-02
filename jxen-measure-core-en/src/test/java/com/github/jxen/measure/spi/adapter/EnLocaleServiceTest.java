package com.github.jxen.measure.spi.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Locale;
import org.junit.jupiter.api.Test;

class EnLocaleServiceTest {

	@Test
	void testGetLocale() {
		assertEquals(Locale.ENGLISH, new EnLocaleService().getLocale());
	}

	@Test
	void testGetAdapter() {
		assertNotNull(new EnLocaleService().getAdapter());
	}
}
