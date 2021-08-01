package com.github.jxen.measure.quantity.impl;

import static com.github.jxen.measure.system.MetricUnits.METER;
import static com.github.jxen.measure.unit.MetricPrefix.kilo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.jxen.math.rational.BigRational;
import com.github.jxen.math.rational.Rational;
import javax.measure.Quantity.Scale;
import javax.measure.quantity.Length;
import javax.measure.spi.QuantityFactory;
import org.junit.jupiter.api.Test;

class QuantitiesTest {

  @Test
  void testGetFactory() {
    QuantityFactory<Length> factory = Quantities.getFactory(Length.class);
    assertAll(
        () -> assertThrows(UnsupportedOperationException.class, () -> factory.create(1, METER, Scale.ABSOLUTE)),
        () -> assertEquals(1, factory.create(1, METER).getValue()),
        () -> assertEquals(METER, factory.create(1, METER).getUnit())
    );
  }

  @Test
  void testIsZero() {
    LengthAmount length = new LengthAmount(0, kilo(METER));
    assertTrue(Quantities.isZero(length));
  }

  @Test
  void testIsPositive() {
    LengthAmount length = new LengthAmount(1, kilo(METER));
    assertTrue(Quantities.isPositive(length));
  }

  @Test
  void testIsNegative() {
    LengthAmount length = new LengthAmount(-1, kilo(METER));
    assertTrue(Quantities.isNegative(length));
  }

  @Test
  void testToDouble() {
    LengthAmount length = new LengthAmount(1.5, kilo(METER));
    assertEquals(1500.0, Quantities.toDouble(length, METER));
  }

  @Test
  void testToFloat() {
    LengthAmount length = new LengthAmount(1.5, kilo(METER));
    assertEquals(1500f, Quantities.toFloat(length, METER));
  }

  @Test
  void testToLong() {
    LengthAmount length = new LengthAmount(1.5, kilo(METER));
    assertEquals(1500L, Quantities.toLong(length, METER));
  }

  @Test
  void testToInt() {
    LengthAmount length = new LengthAmount(1.5, kilo(METER));
    assertEquals(1500, Quantities.toInt(length, METER));
  }

  @Test
  void testToRational() {
    LengthAmount length = new LengthAmount(1.5, kilo(METER));
    assertEquals(Rational.valueOf(1500), Quantities.toRational(length, METER));
  }

  @Test
  void testToBigRational() {
    LengthAmount length = new LengthAmount(1.5, kilo(METER));
    assertEquals(BigRational.valueOf(1500), Quantities.toBigRational(length, METER));
  }
}
