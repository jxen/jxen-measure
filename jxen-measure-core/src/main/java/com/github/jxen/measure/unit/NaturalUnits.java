package com.github.jxen.measure.unit;

import static com.github.jxen.measure.unit.LmtUnits.METER_PER_SECOND_SQUARED;
import static com.github.jxen.measure.unit.NaturalUnits.Holder.GRAVITY;

import com.github.jxen.math.rational.Rational;
import javax.measure.Unit;
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
	public static final Unit<Acceleration> STANDARD_GRAVITY = METER_PER_SECOND_SQUARED.multiply(GRAVITY)
			.alternate("gravity");

	private NaturalUnits() {
	}

	static final class Holder {

		static final Rational GRAVITY = new Rational(980_665, 100_000);
	}
}
