package com.github.jxen.measure.unit;

import static com.github.jxen.measure.unit.MetricUnits.Holder.BUILDER;
import static com.github.jxen.measure.unit.MetricUnits.SECOND;

import javax.measure.quantity.Time;

/**
 * {@code TimeUnits} class contains {@link Time} units.
 *
 * @author Denis Murashev
 *
 * @since Measure 0.2
 */
public final class TimeUnits {

	/**
	 * A time unit accepted for use with SI units (standard name {@code min}).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Minute">Wikipedia: Minute</a>
	 */
	public static final AbstractUnit<Time> MINUTE = BUILDER.unit("minute", SECOND, 60, Time.class);

	/**
	 * A time unit accepted for use with SI units (standard name {@code h}).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Hour">Wikipedia: Hour</a>
	 */
	public static final AbstractUnit<Time> HOUR = BUILDER.unit("hour", SECOND, 3600, Time.class);

	/**
	 * A time unit accepted for use with SI units (standard name {@code d}).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Day">Wikipedia: Day</a>
	 */
	public static final AbstractUnit<Time> DAY = BUILDER.unit("day", HOUR, 24, Time.class);

	/**
	 * A unit of duration equal to 7 {@link #DAY} (standard name {@code week}).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Week">Wikipedia: Week</a>
	 */
	public static final AbstractUnit<Time> WEEK = BUILDER.unit("week", DAY, 7, Time.class);

	/**
	 * A time unit accepted for use with SI units (standard name {@code y}).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Year">Wikipedia: Year</a>
	 */
	public static final AbstractUnit<Time> YEAR = BUILDER.unit("year", DAY, 365.2425, Time.class);

	private TimeUnits() {
	}
}
