package com.github.jxen.measure.misc;

import static com.github.jxen.measure.unit.MetricUnits.SECOND;
import static com.github.jxen.measure.unit.NonSiUnits.DEGREE_ANGLE;
import static com.github.jxen.measure.unit.RadianUnits.STERADIAN;
import static com.github.jxen.measure.unit.SystemOfUnitsImpl.unit;
import static com.github.jxen.measure.unit.TimeUnits.MINUTE;

import com.github.jxen.math.rational.Rational;
import com.github.jxen.measure.annotation.AddUnit;
import com.github.jxen.measure.unit.AbstractUnit;
import javax.measure.quantity.Angle;
import javax.measure.quantity.SolidAngle;
import si.uom.quantity.AngularSpeed;

/**
 * {@code LegacyAngleUnits} class contains legacy angle units including obsolete ones.
 *
 * @author Denis Murashev
 *
 * @since Misc Units 0.4
 */
public final class LegacyAngleUnits {

	/**
	 * The gradian is a unit of measurement of an angle, defined as one hundredth of the right angle
	 * (in other words, there are 100 gradians in 90 degrees).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Gradian">Wikipedia: Gradian</a>
	 */
	@AddUnit
	public static final AbstractUnit<Angle> GRADIAN = unit("gradian", DEGREE_ANGLE, new Rational(9, 10), Angle.class);

	/**
	 * A turn is a unit of plane angle measurement equal to 2&pi; radians, 360 degrees or 400 gradians.
	 * A turn is also referred to as a cycle (abbreviated {@code cyc}), revolution (abbreviated {@code rev}),
	 * complete rotation (abbreviated {@code rot}) or full circle.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Turn_(angle)">Wikipedia: Turn (angle)</a>
	 */
	@AddUnit
	public static final AbstractUnit<Angle> REVOLUTION = unit("revolution", DEGREE_ANGLE, 360, Angle.class);

	/**
	 * Revolutions per second or cycles per second.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Cycle_per_second">Wikipedia: Cycle per second</a>
	 */
	@AddUnit
	public static final AbstractUnit<AngularSpeed> REVOLUTION_PER_MINUTE = unit(REVOLUTION.divide(MINUTE),
			AngularSpeed.class);

	/**
	 * A turn is a unit of plane angle measurement equal to 2&pi; radians, 360 degrees or 400 gradians.
	 * A turn is also referred to as a cycle (abbreviated {@code cyc}), revolution (abbreviated {@code rev}),
	 * complete rotation (abbreviated {@code rot}) or full circle.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Turn_(angle)">Wikipedia: Turn (angle)</a>
	 */
	@AddUnit
	public static final AbstractUnit<AngularSpeed> REVOLUTION_PER_SECOND = unit(REVOLUTION.divide(SECOND),
			AngularSpeed.class);

	/**
	 * A unit of solid angle equal to 4&pi; steradians.
	 */
	@AddUnit
	public static final AbstractUnit<SolidAngle> SPHERE = unit("sphere", STERADIAN, 4 * Math.PI, SolidAngle.class);

	private LegacyAngleUnits() {
	}
}
