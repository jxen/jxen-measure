package com.github.jxen.currency;

import static com.github.jxen.currency.CurrencyUnit.SYSTEM_UNIT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.github.jxen.measure.converter.Converters;
import com.github.jxen.measure.dimension.Dimensions;
import com.github.jxen.measure.system.MetricUnits;
import org.junit.jupiter.api.Test;

class CurrencyUnitTest {

  @Test
  void testGetValue() {
    assertEquals(1, SYSTEM_UNIT.getValue());
  }

  @Test
  void testGetMinimal() {
    assertEquals(1, SYSTEM_UNIT.getMinimal());
  }

  @Test
  void testDimension() {
    assertEquals(Dimensions.DIMENSIONLESS, SYSTEM_UNIT.getDimension());
  }

  @Test
  void testGetBaseUnits() {
    assertThrows(UnsupportedOperationException.class, SYSTEM_UNIT::getBaseUnits);
  }

  @Test
  void testGetSystemConverter() {
    assertEquals(Converters.IDENTITY, SYSTEM_UNIT.getSystemConverter());
  }

  @Test
  void testToSystemUnit() {
    assertEquals(SYSTEM_UNIT, SYSTEM_UNIT.toSystemUnit());
  }

  @Test
  void testCompareTo() {
    assertEquals(0, SYSTEM_UNIT.compareTo(new CurrencyUnit("test", 1)));
  }

  @Test
  void testEqualsSame() {
    assertEquals(SYSTEM_UNIT, SYSTEM_UNIT);
  }

  @Test
  void testEqualsTrue() {
    assertEquals(SYSTEM_UNIT, new CurrencyUnit("test", 1));
  }

  @Test
  void testEqualsFalse() {
    assertNotEquals(SYSTEM_UNIT, new CurrencyUnit("test", SYSTEM_UNIT, 0.5));
  }

  @Test
  void testEqualsAnotherType() {
    assertNotEquals(SYSTEM_UNIT, MetricUnits.METER);
  }
}
