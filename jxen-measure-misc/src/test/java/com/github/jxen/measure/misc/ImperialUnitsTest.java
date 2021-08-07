package com.github.jxen.measure.misc;

import static com.github.jxen.measure.misc.ImperialUnits.FAHRENHEIT;
import static com.github.jxen.measure.misc.ImperialUnits.RANKINE;
import static com.github.jxen.measure.system.MetricUnits.KELVIN;
import static com.github.jxen.measure.system.MiscUnits.CELSIUS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.jxen.measure.quantity.impl.Quantities;
import org.junit.jupiter.api.Test;

public class ImperialUnitsTest {

  @Test
  void testRankine() {
    assertEquals(Quantities.of(100.0, KELVIN), Quantities.of(180, RANKINE).to(KELVIN));
  }

  @Test
  void testFahrenheitCase1() {
    assertEquals(0, Quantities.of(32, FAHRENHEIT).to(CELSIUS).getValue().doubleValue(), 1e-10);
  }

  @Test
  void testFahrenheitCase2() {
    assertEquals(100.0, Quantities.of(212, FAHRENHEIT).to(CELSIUS).getValue().doubleValue(), 1e-10);
  }
}
