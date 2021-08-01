package com.github.jxen.measure.system;

import static com.github.jxen.measure.dimension.Dimensions.DIMENSIONLESS;
import static com.github.jxen.measure.unit.UnitUtil.unit;

import com.github.jxen.measure.annotation.AddUnit;
import com.github.jxen.measure.unit.AbstractUnit;
import com.github.jxen.measure.unit.SystemOfUnitsImpl;
import javax.measure.quantity.Dimensionless;
import javax.measure.spi.SystemOfUnits;

/**
 * {@code MathConstants} class contains natural physical unit constants.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.5
 */
public final class MathConstants {

  /**
   * Just simple dimensionless unit.
   */
  @AddUnit
  public static final AbstractUnit<Dimensionless> UNIT = unit("unit", DIMENSIONLESS, Dimensionless.class);

  /**
   * The number &pi; is a mathematical constant.
   * Originally defined as the ratio of a circle's circumference to its diameter.
   *
   * @see <a href="https://en.wikipedia.org/wiki/Pi">Wikipedia: Pi</a>
   */
  @AddUnit
  public static final AbstractUnit<Dimensionless> PI = unit("pi", UNIT, Math.PI, Dimensionless.class);

  /**
   * The instance of {@link SystemOfUnits}.
   */
  public static final SystemOfUnits SYSTEM = SystemOfUnitsImpl.builder("Math Constants")
      .add(MathConstants.class)
      .build();

  private MathConstants() {
  }
}
