package com.github.jxen.measure.spi.adapter;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class MiscRuLocaleServiceTest {

  @Test
  void testGetAdapter() {
    assertNotNull(new MiscRuLocaleService().getAdapter());
  }
}
