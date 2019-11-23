package com.github.jxen.measure.nonsi;

import static com.github.jxen.measure.nonsi.TroyUnits.BuilderHolder.BUILDER;
import static com.github.jxen.measure.unit.MechanicalUnits.GRAM;

import com.github.jxen.math.rational.BigRational;
import com.github.jxen.measure.unit.AbstractUnit;
import com.github.jxen.measure.unit.SystemOfUnitsImpl;
import javax.measure.quantity.Mass;
import javax.measure.spi.SystemOfUnits;

/**
 * {@code TroyUnits}  class represents Troy unit system.
 *
 * @author Denis Murashev
 * @since Non-SI Units 0.1
 */
public final class TroyUnits {

	/**
	 * Troy grain.
	 */
	public static final AbstractUnit<Mass> GRAIN = add("grain", GRAM, new BigRational(6_479_891, 100_000_000));

	/**
	 * Pennyweight.
	 */
	public static final AbstractUnit<Mass> PENNYWEIGHT = add("pennyweight", GRAIN, 24);

	/**
	 * Troy ounce.
	 */
	public static final AbstractUnit<Mass> OUNCE = add("ounce_troy", GRAIN, 480);

	/**
	 * Troy pound.
	 */
	public static final AbstractUnit<Mass> POUND = add("pound_troy", OUNCE, 12);

	/**
	 * Mite.
	 */
	public static final AbstractUnit<Mass> MITE = add("mite", GRAIN, new BigRational(1, 20));

	/**
	 * Droit.
	 */
	public static final AbstractUnit<Mass> DROIT = add("droit", GRAIN, new BigRational(1, 480));

	/**
	 * Perit.
	 */
	public static final AbstractUnit<Mass> PERIT = add("perit", GRAIN, new BigRational(1, 9600));

	/**
	 * Blank.
	 */
	public static final AbstractUnit<Mass> BLANK = add("blank", GRAIN, new BigRational(1, 230_400));

	/**
	 * Dram (or drachm).
	 */
	public static final AbstractUnit<Mass> DRAM = add("dram", POUND, new BigRational(1, 96));

	/**
	 * Scruple.
	 */
	public static final AbstractUnit<Mass> SCRUPLE = add("scruple", POUND, new BigRational(1, 288));

	///////////////////////// System of MetricUnits /////////////////////////

	/**
	 * The instance of {@link SystemOfUnits}.
	 */
	public static final SystemOfUnits SYSTEM = BUILDER.build();

	private TroyUnits() {
	}

	private static AbstractUnit<Mass> add(String name, AbstractUnit<Mass> unit, Number factor) {
		return BUILDER.unit(name, unit, factor, Mass.class);
	}

	static final class BuilderHolder {

		static final SystemOfUnitsImpl.Builder BUILDER = SystemOfUnitsImpl.builder("Troy");

		private BuilderHolder() {
		}
	}
}
