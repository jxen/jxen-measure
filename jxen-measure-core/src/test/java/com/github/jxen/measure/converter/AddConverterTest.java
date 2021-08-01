package com.github.jxen.measure.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.jxen.math.rational.Rational;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.measure.UnitConverter;
import org.junit.jupiter.api.Test;

class AddConverterTest {

  @Test
  void testCreateFailure() {
    assertThrows(IllegalArgumentException.class, () -> Converters.fromOffset(null));
  }

  @Test
  void testIdentity() {
    assertEquals(Converters.IDENTITY, Converters.fromOffset(0));
  }

  @Test
  void testNotIdentity() {
    assertFalse(Converters.fromOffset(1).isIdentity());
  }

  @Test
  void testLinear() {
    assertFalse(Converters.fromOffset(1).isLinear());
  }

  @Test
  void testInverse() {
    UnitConverter converter = Converters.fromOffset(1).inverse();
    assertEquals(0.0, converter.convert(1.0));
  }

  @Test
  void testConvertNumber() {
    UnitConverter converter = Converters.fromOffset(1);
    assertEquals(Rational.TWO, converter.convert(Rational.ONE));
  }

  @Test
  void testConvertDouble() {
    UnitConverter converter = Converters.fromOffset(1);
    assertEquals(2.0, converter.convert(1.0));
  }

  @Test
  void testConcatenateCase1() {
    UnitConverter converter = Converters.fromOffset(1).concatenate(Converters.fromOffset(1));
    assertEquals(3.0, converter.convert(1.0));
  }

  @Test
  void testConcatenateCase2() {
    UnitConverter converter = Converters.fromOffset(1).concatenate(Converters.fromOffset(-1));
    assertEquals(Converters.IDENTITY, converter);
  }

  @Test
  void testConcatenateCase3() {
    UnitConverter converter = Converters.fromOffset(1).concatenate(Converters.IDENTITY);
    assertEquals(2.0, converter.convert(1.0));
  }

  @Test
  void testConcatenateCase4() {
    UnitConverter converter = Converters.fromOffset(1).concatenate(Converters.fromFactor(2));
    assertEquals(3.0, converter.convert(1.0));
  }

  @Test
  void testConversionSteps() {
    List<? extends UnitConverter> steps = Converters.fromOffset(1).getConversionSteps();
    assertEquals(Collections.singletonList(Converters.fromOffset(1)), steps);
  }

  @Test
  void testToString() {
    assertEquals("AddConverter(1)", Converters.fromOffset(1).toString());
  }

  @Test
  void testEquals() {
    UnitConverter converter = Converters.fromOffset(1);
    assertEquals(converter, converter);
  }

  @Test
  void testNotEquals() {
    assertNotEquals(Converters.fromOffset(1), Converters.fromFactor(2));
  }
}
