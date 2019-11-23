package com.github.jxen.measure.unit;

import static com.github.jxen.measure.dimension.Dimensions.DIMENSIONLESS;
import static com.github.jxen.measure.dimension.Dimensions.LENGTH;
import static com.github.jxen.measure.dimension.Dimensions.MASS;
import static com.github.jxen.measure.dimension.Dimensions.TIME;
import static com.github.jxen.measure.unit.MetricUnits.Holder.BUILDER;
import static com.github.jxen.measure.unit.MetricUnits.Holder.R1_1000;
import static com.github.jxen.measure.unit.MetricUnits.Holder.R1_60;

import com.github.jxen.math.rational.Rational;
import javax.measure.quantity.Acceleration;
import javax.measure.quantity.Angle;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Time;
import javax.measure.quantity.Volume;
import javax.measure.spi.SystemOfUnits;
import si.uom.quantity.Density;

/**
 * {@code MetricUnits} class contains SI units.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.1
 */
public final class MetricUnits {

	/**
	 * The SI base unit for length quantities (standard name {@code m}).
	 * One meter was redefined in 1983 as the distance traveled by light
	 * in a vacuum in 1/299,792,458 of a second.
	 */
	public static final AbstractUnit<Length> METER = BUILDER.unit("meter", LENGTH, Length.class);

	/**
	 * The SI base unit for mass quantities (standard name {@code kg}.
	 * It is the only SI unit with a prefix as part of its name and symbol.
	 * The kilogram is equal to the mass of an international prototype
	 * in the form of a platinum-iridium cylinder kept at Sevres in France.
	 *
	 * @see #GRAM
	 */
	public static final AbstractUnit<Mass> KILOGRAM = BUILDER.unit("kilogram", MASS, Mass.class);

	/**
	 * The SI base unit for duration quantities (standard name {@code s}).
	 * It is defined as the duration of 9,192,631,770 cycles of radiation
	 * corresponding to the transition between two hyperfine
	 * levels of the ground state of cesium (1967 Standard).
	 */
	public static final AbstractUnit<Time> SECOND = BUILDER.unit("second", TIME, Time.class);

	/////////////////////// SI derived product units ///////////////////////

	/**
	 * The SI unit for speed quantities (standard name {@code m/s}).
	 */
	public static final AbstractUnit<Speed> METER_PER_SECOND = BUILDER.unit(METER.divide(SECOND), Speed.class);

	/**
	 * The SI unit for acceleration quantities (standard name {@code m/s2}).
	 */
	public static final AbstractUnit<Acceleration> METER_PER_SQUARE_SECOND = BUILDER.unit(METER.divide(SECOND.pow(2)),
			Acceleration.class);

	/**
	 * The SI unit for area quantities (standard name {@code m2}).
	 */
	public static final AbstractUnit<Area> SQUARE_METER = BUILDER.unit(METER.pow(2), Area.class);

	/**
	 * The SI unit for volume quantities (standard name {@code m3}).
	 */
	public static final AbstractUnit<Volume> CUBIC_METER = BUILDER.unit(METER.pow(3), Volume.class);

	/**
	 * The SI unit for density quantities (standard name {@code kg/m3}).
	 */
	public static final AbstractUnit<Density> KILOGRAM_PER_CUBIC_METER = BUILDER.unit(KILOGRAM.divide(CUBIC_METER),
			Density.class);

	/////////////////////// SI derived alternate units ///////////////////////

	/**
	 * A volume unit accepted for use with SI units (standard name {@code l}).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Litre"> Wikipedia: Litre</a>
	 */
	public static final AbstractUnit<Volume> LITER = BUILDER.unit("liter", CUBIC_METER, R1_1000, Volume.class);

	/**
	 * The SI derived unit for mass quantities (standard name {@code g}).
	 * The base unit for mass quantity is {@link #KILOGRAM}.
	 */
	public static final AbstractUnit<Mass> GRAM = BUILDER.unit("gram", KILOGRAM, R1_1000, Mass.class);

	/**
	 * The SI unit for plane angle quantities (standard name {@code rad}).
	 * One radian is the angle between two radii of a circle such that the
	 * length of the arc between them is equal to the radius.
	 */
	public static final AbstractUnit<Angle> RADIAN = BUILDER.unit("radian", DIMENSIONLESS, Angle.class);

	/**
	 * A time unit accepted for use with SI units
	 * (standard name {@code minute}).
	 */
	public static final AbstractUnit<Time> MINUTE = BUILDER.unit("minute", SECOND, 60, Time.class);

	/**
	 * A time unit accepted for use with SI units (standard name {@code hour}).
	 */
	public static final AbstractUnit<Time> HOUR = BUILDER.unit("hour", SECOND, 3600, Time.class);

	/**
	 * A time unit accepted for use with SI units (standard name {@code day}).
	 */
	public static final AbstractUnit<Time> DAY = BUILDER.unit("day", HOUR, 24, Time.class);

	/**
	 * A unit of duration equal to 7 {@link #DAY} (standard name {@code week}).
	 */
	public static final AbstractUnit<Time> WEEK = BUILDER.unit("week", DAY, 7, Time.class);

	/**
	 * An angle unit accepted for use with SI units (standard name {@code deg}).
	 */
	public static final AbstractUnit<Angle> DEGREE_ANGLE = BUILDER.unit("degree_angle", RADIAN, Math.PI / 180,
			Angle.class);

	/**
	 * An angle unit accepted for use with SI units (standard name {@code '}).
	 */
	public static final AbstractUnit<Angle> MINUTE_ANGLE = BUILDER.unit("minute_angle", DEGREE_ANGLE, R1_60,
			Angle.class);

	/**
	 * An angle unit accepted for use with SI units (standard name {code ''}).
	 */
	public static final AbstractUnit<Angle> SECOND_ANGLE = BUILDER.unit("second_angle", MINUTE_ANGLE, R1_60,
			Angle.class);

	/**
	 * The instance of {@link SystemOfUnits}.
	 */
	public static final SystemOfUnits SYSTEM = BUILDER.build();

	private MetricUnits() {
	}

	static class Holder {

		static final SystemOfUnitsImpl.Builder BUILDER = SystemOfUnitsImpl.builder("SI");

		static final Rational R1_1000 = new Rational(1, 1000);

		static final Rational R1_60 = new Rational(1, 60);
	}
}
