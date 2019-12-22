package com.github.jxen.measure.unit;

import static com.github.jxen.measure.unit.AmpereUnits.VOLT;
import static com.github.jxen.measure.unit.MeterUnits.CUBIC_METER;
import static com.github.jxen.measure.unit.MeterUnits.SQUARE_METER;
import static com.github.jxen.measure.unit.MetricUnits.KILOGRAM;
import static com.github.jxen.measure.unit.MetricUnits.METER;
import static com.github.jxen.measure.unit.NaturalUnits.ELEMENTARY_CHARGE;
import static com.github.jxen.measure.unit.RadianUnits.RADIAN;
import static com.github.jxen.measure.unit.SystemOfUnitsImpl.unit;

import com.github.jxen.math.rational.Rational;
import com.github.jxen.measure.annotation.AddUnit;
import java.math.BigDecimal;
import javax.measure.quantity.Angle;
import javax.measure.quantity.Area;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Volume;

/**
 * {@code NonSiUnits} class contains Non-SI units accepted for use with SI units.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.4
 */
public final class NonSiUnits {

	/**
	 * The astronomical unit (symbol: {@code au}) is a unit of length, roughly the distance from Earth to the Sun
	 * and equal to about 150 million kilometres (93 million miles).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Astronomical_unit">Wikipedia: Astronomical unit</a>
	 */
	@AddUnit
	public static final AbstractUnit<Length> ASTRONOMICAL_UNIT = unit("unit^astronomical", METER, 149_597_870_700L,
			Length.class);

	/**
	 * <p>An angle unit accepted for use with SI units (standard name &deg;).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Degree_(angle)">Wikipedia: Degree (angle)</a>
	 */
	@AddUnit
	public static final AbstractUnit<Angle> DEGREE_ANGLE = unit("degree_angle", RADIAN, Math.PI / 180, Angle.class);

	/**
	 * <p>An angle unit accepted for use with SI units (standard name &prime;).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Minute_and_second_of_arc">Wikipedia: Minute and second of arc</a>
	 */
	@AddUnit
	public static final AbstractUnit<Angle> MINUTE_ANGLE = unit("minute_angle", DEGREE_ANGLE, new Rational(1, 60),
			Angle.class);

	/**
	 * <p>An angle unit accepted for use with SI units (standard name &Prime;).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Minute_and_second_of_arc">Wikipedia: Minute and second of arc</a>
	 */
	@AddUnit
	public static final AbstractUnit<Angle> SECOND_ANGLE = unit("second_angle", MINUTE_ANGLE, new Rational(1, 60),
			Angle.class);

	/**
	 * A unit of area equal to {@code 100 m}<sup>2</sup> (abbreviation {@code a}).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Hectare#Are">Wikipedia: Are</a>
	 */
	@AddUnit
	public static final AbstractUnit<Area> ARE = unit("are", SQUARE_METER, 100, Area.class);

	/**
	 * A unit of area equal to {@code 100 ares} (abbreviation {@code ha}).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Hectare">Wikipedia: Hectare</a>
	 */
	@AddUnit
	public static final AbstractUnit<Area> HECTARE = unit("hectare", ARE, 100, Area.class);

	/**
	 * <p>A volume unit accepted for use with SI units (standard name {@code l}).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Litre">Wikipedia: Litre</a>
	 */
	@AddUnit
	public static final AbstractUnit<Volume> LITER = unit("liter", CUBIC_METER, new Rational(1, 1000), Volume.class);

	/**
	 * <p>The tonne (non-SI unit, symbol: {@code t}), commonly referred to as the metric ton in Canada,
	 * the United Kingdom and the United States, is a non-SI metric unit of mass equal to 1,000 kilograms.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Tonne">Wikipedia: Tonne</a>
	 */
	@AddUnit
	public static final AbstractUnit<Mass> TONNE = unit("tonne", KILOGRAM, 1000, Mass.class);

	/**
	 * <p>The tonne (non-SI unit, symbol: {@code t}), commonly referred to as the metric ton in Canada,
	 * the United Kingdom and the United States, is a non-SI metric unit of mass equal to 1,000 kilograms.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Dalton_(unit)">Wikipedia: Dalton (unit)</a>
	 */
	@AddUnit
	public static final AbstractUnit<Mass> DALTON = unit("dalton", KILOGRAM, new BigDecimal("1.66053906660E-27"),
			Mass.class);

	/**
	 * <p>The tonne (non-SI unit, symbol: {@code t}), commonly referred to as the metric ton in Canada,
	 * the United Kingdom and the United States, is a non-SI metric unit of mass equal to 1,000 kilograms.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Electronvolt">Wikipedia: Electronvolt</a>
	 */
	@AddUnit
	public static final AbstractUnit<Energy> ELECTRON_VOLT = unit(ELEMENTARY_CHARGE.multiply(VOLT)
			.alternate("electronvolt"), Energy.class);

	private NonSiUnits() {
	}
}
