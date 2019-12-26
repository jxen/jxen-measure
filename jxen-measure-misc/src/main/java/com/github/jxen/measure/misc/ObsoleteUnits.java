package com.github.jxen.measure.misc;

import static com.github.jxen.measure.unit.MeterUnits.SQUARE_METER;
import static com.github.jxen.measure.unit.MetricUnits.KILOGRAM;
import static com.github.jxen.measure.unit.SystemOfUnitsImpl.unit;

import com.github.jxen.measure.annotation.AddUnit;
import com.github.jxen.measure.unit.AbstractUnit;
import com.github.jxen.measure.unit.SystemOfUnitsImpl;
import javax.measure.quantity.Area;
import javax.measure.quantity.Mass;
import javax.measure.spi.SystemOfUnits;

/**
 * {@code ObsoleteUnits} class contains non-SI units including obsolete ones.
 *
 * @author Denis Murashev
 *
 * @since Misc Units 0.4
 */
public final class ObsoleteUnits {

	/**
	 * <p>The quintal or centner is a historical unit of mass which is usually defined as 100 base units of kilograms.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Quintal">Wikipedia: Quintal</a>
	 */
	@AddUnit
	public static final AbstractUnit<Mass> CENTNER = unit("centner", KILOGRAM, 100, Mass.class);

	/**
	 * A unit of area equal to {@code 100 m}<sup>2</sup> (abbreviation {@code a}).
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Hectare#Are">Wikipedia: Are</a>
	 */
	@AddUnit
	public static final AbstractUnit<Area> ARE = unit("are", SQUARE_METER, 100, Area.class);

	/**
	 * The instance of {@link SystemOfUnits}.
	 */
	public static final SystemOfUnits SYSTEM = SystemOfUnitsImpl.builder("Obsolete").add(ObsoleteUnits.class).build();

	private ObsoleteUnits() {
	}
}
