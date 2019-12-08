package com.github.jxen.measure.unit;

import static com.github.jxen.measure.unit.LmtUnits.METER_PER_SECOND_SQUARED;

import com.github.jxen.measure.annotation.AddUnit;
import java.math.BigDecimal;
import javax.measure.quantity.Acceleration;

/**
 * {@code NaturalUnits} class contains natural units.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.2
 */
public final class NaturalUnits {

	/**
	 * Standard gravity at earth surface.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Gravitational_acceleration">Wikipedia: Gravitational acceleration</a>
	 */
	@AddUnit
	public static final AbstractUnit<Acceleration> STANDARD_GRAVITY = METER_PER_SECOND_SQUARED
			.multiply(new BigDecimal("9.80665")).alternate("gravity");

	private NaturalUnits() {
	}
}
