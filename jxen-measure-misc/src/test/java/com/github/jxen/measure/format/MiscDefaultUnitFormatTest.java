package com.github.jxen.measure.format;

import com.github.jxen.measure.misc.ImperialUnits;
import com.github.jxen.measure.misc.RussianUnits;
import com.github.jxen.measure.misc.TroyUnits;
import java.util.Locale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MiscDefaultUnitFormatTest {

  @BeforeEach
  void setUp() {
    Locale.setDefault(Locale.US);
  }

  @Test
  void testFormatImperialUnits() {
    Assertions.assertEquals("in", new MiscDefaultUnitFormat().format(ImperialUnits.INCH));
  }

  @Test
  void testFormatRussianUnits() {
    Assertions.assertEquals("in", new MiscDefaultUnitFormat().format(RussianUnits.INCH));
  }

  @Test
  void testFormatTroyUnits() {
    Assertions.assertEquals("lb\u202Ft", new MiscDefaultUnitFormat().format(TroyUnits.POUND));
  }
}
