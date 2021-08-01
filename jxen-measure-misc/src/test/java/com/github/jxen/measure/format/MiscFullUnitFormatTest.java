package com.github.jxen.measure.format;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.jxen.measure.misc.ApothecariesUnits;
import com.github.jxen.measure.misc.ImperialUnits;
import com.github.jxen.measure.misc.RussianUnits;
import com.github.jxen.measure.misc.TroyUnits;
import com.github.jxen.measure.misc.UsCustomaryUnits;
import java.util.Locale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MiscFullUnitFormatTest {

  @BeforeEach
  void setUp() {
    Locale.setDefault(Locale.US);
  }

  @Test
  void testFormatTroyUnits() {
    assertEquals("troy\u202Fpound", new MiscFullUnitFormat().format(TroyUnits.POUND));
  }

  @Test
  void testFormatApothecariesUnits() {
    assertEquals("grain", new MiscFullUnitFormat().format(ApothecariesUnits.GRAIN));
  }

  @Test
  void testFormatImperialUnits() {
    assertEquals("inch", new MiscFullUnitFormat().format(ImperialUnits.INCH));
  }

  @Test
  void testFormatUsCustomaryUnits() {
    assertEquals("inch", new MiscFullUnitFormat().format(UsCustomaryUnits.INCH));
  }

  @Test
  void testFormatRussianUnits() {
    assertEquals("inch", new MiscFullUnitFormat().format(RussianUnits.INCH));
  }
}
