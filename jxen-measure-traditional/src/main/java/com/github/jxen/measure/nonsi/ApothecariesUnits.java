package com.github.jxen.measure.nonsi;

import static com.github.jxen.measure.nonsi.ApothecariesUnits.Holder.BUILDER;

import com.github.jxen.math.rational.Rational;
import com.github.jxen.measure.unit.AbstractUnit;
import com.github.jxen.measure.unit.SystemOfUnitsImpl;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Volume;
import javax.measure.spi.SystemOfUnits;

/**
 * {@code ApothecariesUnits} class represents Apothecaries' unit system.
 *
 * @author Denis Murashev
 *
 * @since Non-SI Units 0.2
 */
public final class ApothecariesUnits {

	/**
	 * Grain.
	 *
	 * @see ImperialUnits#GRAIN
	 */
	public static final AbstractUnit<Mass> GRAIN = BUILDER.unit(ImperialUnits.GRAIN, Mass.class);

	/**
	 * Apothecaries' scruple.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Apothecaries%27_system">Wikipedia: Apothecaries' system</a>
	 */
	public static final AbstractUnit<Mass> SCRUPLE = BUILDER.unit("scruple", GRAIN, 20, Mass.class);

	/**
	 * Apothecaries' dram.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Apothecaries%27_system">Wikipedia: Apothecaries' system</a>
	 */
	public static final AbstractUnit<Mass> DRAM = BUILDER.unit("dram^apothecary", GRAIN, 60, Mass.class);

	/**
	 * Apothecaries' ounce (equal to Troy ounce).
	 *
	 * @see TroyUnits#OUNCE
	 */
	public static final AbstractUnit<Mass> OUNCE = BUILDER.unit(TroyUnits.OUNCE, Mass.class);

	/**
	 * Apothecaries' pound (equal to Troy pound).
	 *
	 * @see TroyUnits#POUND
	 */
	public static final AbstractUnit<Mass> POUND = BUILDER.unit(TroyUnits.POUND, Mass.class);

	/**
	 * Fluid ounce.
	 *
	 * @see ImperialUnits#FLUID_OUNCE
	 */
	public static final AbstractUnit<Volume> FLUID_OUNCE = BUILDER.unit(ImperialUnits.FLUID_OUNCE, Volume.class);

	/**
	 * <p>A fluid ounce (abbreviated {@code fl oz}, or {@code oz fl}) is a unit of volume (also called capacity)
	 * typically used for measuring liquids.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Dram_(unit)#Dram_(volume)">Wikipedia: Dram (volume)</a>
	 */
	public static final AbstractUnit<Volume> FLUID_DRAM = BUILDER.unit("dram^fluid", FLUID_OUNCE,
			Rational.ONE_EIGHTH, Volume.class);

	/**
	 * <p>The fluid dram (or fluid drachm in British spelling) is defined as <sup>1</sup>/<sub>8</sub> of a fluid ounce.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Dram_(unit)#Dram_(volume)">Wikipedia: Dram (volume)</a>
	 */
	public static final AbstractUnit<Volume> FLUID_SCRUPLE = BUILDER.unit("scruple^fluid", FLUID_DRAM,
			Rational.ONE_THIRD, Volume.class);

	/**
	 * <p>The minim (abbreviated {@code min}) is a unit of volume in the imperial system of measurement.
	 * Specifically it is <sup>1</sup>/<sub>60</sub> of a fluid drachm or <sup>1</sup>/<sub>480</sub> of a fluid ounce.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Minim_(unit)">Wikipedia: Minim (unit)</a>
	 */
	public static final AbstractUnit<Volume> MINIM = BUILDER.unit("minim", FLUID_SCRUPLE,
			new Rational(1, 20), Volume.class);

	/**
	 * The instance of {@link SystemOfUnits}.
	 */
	public static final SystemOfUnits SYSTEM = BUILDER.build();

	private ApothecariesUnits() {
	}

	static final class Holder {

		static final SystemOfUnitsImpl.Builder BUILDER = SystemOfUnitsImpl.builder("Apothecaries");

		private Holder() {
		}
	}
}
