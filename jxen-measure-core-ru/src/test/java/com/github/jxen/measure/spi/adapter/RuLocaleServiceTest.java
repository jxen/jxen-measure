package com.github.jxen.measure.spi.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Locale;
import org.junit.jupiter.api.Test;

class RuLocaleServiceTest {

	@Test
	void testGetLocale() {
		assertEquals(new Locale("ru", "RU"), new RuLocaleService().getLocale());
	}

	@Test
	void testGetAdapter() {
		assertNotNull(new RuLocaleService().getAdapter());
	}
}
