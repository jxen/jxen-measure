package com.github.jxen.measure.format;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.jxen.measure.data.Metal;
import java.util.Locale;
import org.junit.jupiter.api.Test;

class SubstanceFormatTest {

  @Test
  void testFormat() {
    Locale.setDefault(Locale.US);
    assertEquals("gold", new SubstanceFormat().format(Metal.GOLD));
  }
}
