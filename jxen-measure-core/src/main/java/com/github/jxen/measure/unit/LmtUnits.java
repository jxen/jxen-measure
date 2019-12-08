package com.github.jxen.measure.unit;

import static com.github.jxen.measure.dimension.Dimensions.DIMENSIONLESS;
import static com.github.jxen.measure.unit.LmtUnits.Holder.R1_1000;
import static com.github.jxen.measure.unit.LmtUnits.Holder.R1_60;
import static com.github.jxen.measure.unit.MetricUnits.Holder.BUILDER;
import static com.github.jxen.measure.unit.MetricUnits.KILOGRAM;
import static com.github.jxen.measure.unit.MetricUnits.METER;
import static com.github.jxen.measure.unit.MetricUnits.SECOND;
import static com.github.jxen.measure.unit.TimeUnits.HOUR;

import com.github.jxen.math.rational.Rational;
import javax.measure.quantity.Acceleration;
import javax.measure.quantity.Angle;
import javax.measure.quantity.Area;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Force;
import javax.measure.quantity.Frequency;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Power;
import javax.measure.quantity.Pressure;
import javax.measure.quantity.SolidAngle;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Volume;
import si.uom.quantity.Density;

/**
 * {@code LmtUnits} class contains SI units based on {@link MetricUnits#METER} ({@code L}),
 * {@link MetricUnits#KILOGRAM}  ({@code M}) and {@link MetricUnits#SECOND} ({@code T}).
 *
 * @author Denis Murashev
 *
 * @since Measure 0.2
 */
public final class LmtUnits {

	/**
	 * <p>The hertz (symbol: {@code Hz}) is the derived unit of frequency in the International System of Units (SI)
	 * and is defined as cycles per one second.
	 *
	 * <p>It is named after Heinrich Rudolf Hertz,
	 * the first person to provide conclusive proof of the existence of electromagnetic waves.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Hertz">Wikipedia: Hertz</a>
	 */
	public static final AbstractUnit<Frequency> HERTZ = BUILDER.unit(SECOND.inverse().alternate("hertz"),
			Frequency.class);

	/**
	 * <p>The radian is the SI unit for measuring angles, and is the standard unit of angular measure
	 * used in many areas of mathematics.
	 * The length of an arc of a unit circle is numerically equal to the measurement in radians of the angle
	 * that it subtends.
	 *
	 * <p>The symbol {@code rad} can be used to represent the radian,
	 * but this is often omitted, especially in mathematical writing.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Radian">Wikipedia: Radian</a>
	 */
	public static final AbstractUnit<Angle> RADIAN = BUILDER.unit("radian", DIMENSIONLESS, Angle.class);

	/**
	 * <p>The steradian (symbol: {@code sr}) or square radian is the SI unit of solid angle.
	 * It is used in three-dimensional geometry, and is analogous to the radian, which quantifies planar angles.
	 *
	 * <p>A steradian can be defined as the solid angle subtended at the center of a unit sphere
	 * by a unit area on its surface.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Steradian">Wikipedia: Steradian</a>
	 */
	public static final AbstractUnit<SolidAngle> STERADIAN = BUILDER.unit("steradian", DIMENSIONLESS, SolidAngle.class);

	/**
	 * <p>The newton (symbol: {@code N}) is the International System of Units (SI) derived unit of force.
	 * It is named after Isaac Newton in recognition of his work on classical mechanics,
	 * specifically Newton's second law of motion.
	 *
	 * <p>One newton is the force needed to accelerate one kilogram of mass at the rate of one meter per second squared
	 * in the direction of the applied force.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Newton_(unit)">Wikipedia: Newton (unit)</a>
	 */
	public static final AbstractUnit<Force> NEWTON = BUILDER.unit(METER.multiply(KILOGRAM).divide(SECOND.pow(2))
			.alternate("newton"), Force.class);

	/**
	 * <p>The pascal (symbol: {@code Pa}) is the SI derived unit of pressure used to quantify internal pressure, stress,
	 * Young's modulus and ultimate tensile strength.
	 * The unit, named after Blaise Pascal, is defined as one newton per square metre.
	 *
	 * <p>One pascal is the pressure exerted by a force of magnitude one newton perpendicularly
	 * upon an area of one square meter.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Pascal_(unit)">Wikipedia: Pascal (unit)</a>
	 */
	public static final AbstractUnit<Pressure> PASCAL = BUILDER.unit(NEWTON.divide(METER.pow(2)).alternate("pascal"),
			Pressure.class);

	/**
	 * <p>The joule (symbol: {@code J}) is a derived unit of energy in the International System of Units.
	 * It is equal to the energy transferred to (or work done on) an object
	 * when a force of one newton acts on that object in the direction of the force's motion
	 * through a distance of one meter (1 newton meter or N&bull;m).
	 * It is also the energy dissipated as heat when an electric current of one ampere passes
	 * through a resistance of one ohm for one second.
	 *
	 * <p>It is named after the English physicist James Prescott Joule (1818-1889).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Joule">Wikipedia: Joule</a>
	 */
	public static final AbstractUnit<Energy> JOULE = BUILDER.unit(NEWTON.multiply(METER).alternate("joule"),
			Energy.class);

	/**
	 * <p>The watt (symbol: {@code W}) is a unit of power.
	 * In the International System of Units (SI) it is defined as a derived unit of 1 joule per second,
	 * and is used to quantify the rate of energy transfer
	 *
	 * <p>It is named after the British scientist James Watt (1736-1819).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Watt">Wikipedia: Watt</a>
	 */
	public static final AbstractUnit<Power> WATT = BUILDER.unit(JOULE.divide(SECOND).alternate("watt"), Power.class);

	/**
	 * <p>The SI unit for speed quantities (standard name {@code m/s}).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Metre_per_second">Wikipedia: Metre per second</a>
	 */
	public static final AbstractUnit<Speed> METER_PER_SECOND = BUILDER.unit(METER.divide(SECOND), Speed.class);

	/**
	 * <p>The SI unit for acceleration quantities (standard name m/s&sup2;).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Metre_per_second_squared">Wikipedia: Metre per second squared</a>
	 */
	public static final AbstractUnit<Acceleration> METER_PER_SECOND_SQUARED = BUILDER.unit(METER.divide(SECOND.pow(2)),
			Acceleration.class);

	/**
	 * <p>The SI unit for area quantities (standard name m&sup2;).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Square_metre">Wikipedia: Square metre</a>
	 */
	public static final AbstractUnit<Area> SQUARE_METER = BUILDER.unit(METER.pow(2), Area.class);

	/**
	 * <p>The SI unit for volume quantities (standard name m&sup3;).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Cubic_metre">Wikipedia: Cubic metre</a>
	 */
	public static final AbstractUnit<Volume> CUBIC_METER = BUILDER.unit(METER.pow(3), Volume.class);

	/**
	 * <p>The SI unit for density quantities (standard name kg/m&sup3;).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Kilogram_per_cubic_metre">Wikipedia: Kilogram per cubic metre</a>
	 */
	public static final AbstractUnit<Density> KILOGRAM_PER_CUBIC_METER = BUILDER.unit(KILOGRAM.divide(CUBIC_METER),
			Density.class);

	/**
	 * <p>A unit of length expressing the number of kilometers (abbreviation {@code km}).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Kilometre">Wikipedia: Kilometre</a>
	 */
	public static final AbstractUnit<Length> KILOMETER = BUILDER.unit(MetricPrefix.kilo(METER), Length.class);

	/**
	 * <p>A unit of length expressing the number of centimeters (abbreviation {@code cm}).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Centimetre">Wikipedia: Centimetre</a>
	 */
	public static final AbstractUnit<Length> CENTIMETER = BUILDER.unit(MetricPrefix.centi(METER), Length.class);

	/**
	 * <p>A unit of length expressing the number of millimeters (abbreviation {@code mm}).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Millimetre">Wikipedia: Millimetre</a>
	 */
	public static final AbstractUnit<Length> MILLIMETER = BUILDER.unit(MetricPrefix.milli(METER), Length.class);

	/**
	 * A unit of area equal to {@code 100 m}<sup>2</sup> (abbreviation {@code a}).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Hectare#Are">Wikipedia: Are</a>
	 */
	public static final AbstractUnit<Area> ARE = BUILDER.unit("are", SQUARE_METER, 100, Area.class);

	/**
	 * A unit of area equal to {@code 100 ares} (abbreviation {@code ha}).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Hectare">Wikipedia: Hectare</a>
	 */
	public static final AbstractUnit<Area> HECTARE = BUILDER.unit("hectare", ARE, 100, Area.class);

	/**
	 * <p>A volume unit accepted for use with SI units (standard name {@code l}).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Litre">Wikipedia: Litre</a>
	 */
	public static final AbstractUnit<Volume> LITER = BUILDER.unit("liter", CUBIC_METER, R1_1000, Volume.class);

	/**
	 * <p>The SI derived unit for mass quantities (standard name {@code g}).
	 * The base unit for mass quantity is {@link MetricUnits#KILOGRAM}.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Gram">Wikipedia: Gram</a>
	 */
	public static final AbstractUnit<Mass> GRAM = BUILDER.unit("gram", KILOGRAM, R1_1000, Mass.class);

	/**
	 * <p>The quintal or centner is a historical unit of mass which is usually defined as 100 base units of kilograms.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Quintal">Wikipedia: Quintal</a>
	 */
	public static final AbstractUnit<Mass> CENTNER = BUILDER.unit("centner", KILOGRAM, 100, Mass.class);

	/**
	 * <p>The tonne (non-SI unit, symbol: {@code t}), commonly referred to as the metric ton in Canada,
	 * the United Kingdom and the United States, is a non-SI metric unit of mass equal to 1,000 kilograms.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Tonne">Wikipedia: Tonne</a>
	 */
	public static final AbstractUnit<Mass> TONNE = BUILDER.unit("tonne", KILOGRAM, 1000, Mass.class);

	/**
	 * <p>A unit of speed expressing the number of international {@link #KILOMETER kilometres}
	 * per {@link TimeUnits#HOUR hour} (abbreviation {@code km/h}).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Kilometres_per_hour">Wikipedia: Kilometres per hour</a>
	 */
	public static final AbstractUnit<Speed> KILOMETER_PER_HOUR = BUILDER.unit(KILOMETER.divide(HOUR), Speed.class);

	/**
	 * <p>An angle unit accepted for use with SI units (standard name &deg;).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Degree_(angle)">Wikipedia: Degree (angle)</a>
	 */
	public static final AbstractUnit<Angle> DEGREE_ANGLE = BUILDER.unit("degree_angle", RADIAN, Math.PI / 180,
			Angle.class);

	/**
	 * <p>An angle unit accepted for use with SI units (standard name &prime;).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Minute_and_second_of_arc">Wikipedia: Minute and second of arc</a>
	 */
	public static final AbstractUnit<Angle> MINUTE_ANGLE = BUILDER.unit("minute_angle", DEGREE_ANGLE, R1_60,
			Angle.class);

	/**
	 * <p>An angle unit accepted for use with SI units (standard name &Prime;).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Minute_and_second_of_arc">Wikipedia: Minute and second of arc</a>
	 */
	public static final AbstractUnit<Angle> SECOND_ANGLE = BUILDER.unit("second_angle", MINUTE_ANGLE, R1_60,
			Angle.class);

	private LmtUnits() {
	}

	static class Holder {

		static final Rational R1_60 = new Rational(1, 60);

		static final Rational R1_1000 = new Rational(1, 1000);
	}
}
