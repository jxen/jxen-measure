package com.github.jxen.measure.spi.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class RuLocaleServiceTest {

  @Test
  void testGetLocale() {
    assertEquals(RuLocaleService.RU, new RuLocaleService().getLocale());
  }

  @Test
  void testGetAdapter() {
    assertNotNull(new RuLocaleService().getAdapter());
  }
}
