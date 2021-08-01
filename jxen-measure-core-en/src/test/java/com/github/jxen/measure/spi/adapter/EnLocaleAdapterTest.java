package com.github.jxen.measure.spi.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.jxen.measure.format.LocaleAdapter;
import org.junit.jupiter.api.Test;

class EnLocaleAdapterTest {

  private LocaleAdapter adapter = new EnLocaleAdapter();

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
