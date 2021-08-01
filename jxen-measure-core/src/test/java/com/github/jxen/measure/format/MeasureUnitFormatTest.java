package com.github.jxen.measure.format;

import static com.github.jxen.measure.system.MeterUnits.METER_PER_SECOND;
import static com.github.jxen.measure.system.MeterUnits.METER_PER_SECOND_SQUARED;
import static com.github.jxen.measure.system.MeterUnits.SQUARE_METER;
import static com.github.jxen.measure.system.MetricUnits.METER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.jxen.measure.unit.MetricPrefix;
import com.github.jxen.measure.system.MetricUnits;
import java.io.IOException;
import java.util.Locale;
import javax.measure.MeasurementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MeasureUnitFormatTest {

  @BeforeEach
  void setUp() {
    Locale.setDefault(Locale.US);
  }

  @Test
  void testFormatMeter() {
    assertEquals("m", new MeasureUnitFormat().format(MetricUnits.METER));
  }

  @Test
  void testFormatKilometer() {
    assertEquals("km", new MeasureUnitFormat().format(MetricPrefix.kilo(MetricUnits.METER)));
  }

  @Test
  void testFormatSquareMeter() {
    assertEquals("m\u00B2", new MeasureUnitFormat().format(SQUARE_METER));
  }

  @Test
  void testFormatMeterPerSecond() {
    assertEquals("m\u2044s", new MeasureUnitFormat().format(METER_PER_SECOND));
  }

  @Test
  void testFormatMeterPerSquareSecond() {
    assertEquals("m\u2044s\u00B2", new MeasureUnitFormat().format(METER_PER_SECOND_SQUARED));
  }

  @Test
  void testLabel() {
    assertThrows(UnsupportedOperationException.class, () -> new MeasureUnitFormat().label(null, null));
  }

  @Test
  void testLocaleSensitive() {
    assertTrue(new MeasureUnitFormat().isLocaleSensitive());
  }

  @Test
  void testParse2() {
    assertThrows(UnsupportedOperationException.class, () -> new MeasureUnitFormat().parse(null, null));
  }

  @Test
  void testParse() {
    assertThrows(UnsupportedOperationException.class, () -> new MeasureUnitFormat().parse(null));
  }

  @Test
  void testFailureCase1() {
    assertThrows(MeasurementException.class,
        () -> new MeasureUnitFormat().format(METER, new BrokenAppendable()));
  }

  @Test
  void testFailureCase2() {
    assertThrows(MeasurementException.class,
        () -> new MeasureUnitFormat().format(1, METER, new BrokenAppendable()));
  }

  private static class BrokenAppendable implements Appendable {

    @Override
    public Appendable append(CharSequence csq) throws IOException {
      throw new IOException();
    }

    @Override
    public Appendable append(CharSequence csq, int start, int end) throws IOException {
      throw new IOException();
    }

    @Override
    public Appendable append(char c) throws IOException {
      throw new IOException();
    }
  }
}
