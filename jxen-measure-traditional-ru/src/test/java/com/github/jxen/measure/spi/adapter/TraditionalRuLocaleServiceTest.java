package com.github.jxen.measure.spi.adapter;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class TraditionalRuLocaleServiceTest {

	@Test
	void testGetAdapter() {
		assertNotNull(new TraditionalRuLocaleService().getAdapter());
	}
}
