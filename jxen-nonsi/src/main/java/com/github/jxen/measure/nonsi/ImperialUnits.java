package com.github.jxen.measure.nonsi;

import static com.github.jxen.measure.nonsi.ImperialUnits.BuilderHolder.BUILDER;
import static com.github.jxen.measure.unit.MetricUnits.METER;
import static com.github.jxen.measure.unit.MetricUnits.SECOND;

import com.github.jxen.math.rational.BigRational;
import com.github.jxen.math.rational.Rational;
import com.github.jxen.measure.unit.AbstractUnit;
import com.github.jxen.measure.unit.SystemOfUnitsImpl;
import javax.measure.Unit;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Volume;
import javax.measure.spi.SystemOfUnits;

/**
 * {@code ImperialUnits} class represents British imperial unit system.
 *
 * @author Denis Murashev
 * @since Non-SI Units 0.1
 */
public final class ImperialUnits {

	///////////////////////// Length British Imperial Units /////////////////////////

	/**
	 * Inch.
	 */
	public static final AbstractUnit<Length> INCH = BUILDER.unit("inch", METER, new BigRational(254, 10_000),
			Length.class);

	/**
	 * Line.
	 */
	public static final AbstractUnit<Length> LINE = BUILDER.unit("line", INCH, new Rational(1, 12), Length.class);

	/**
	 * Point.
	 */
	public static final AbstractUnit<Length> POINT = BUILDER.unit("point", LINE, Rational.ONE_SIXTH, Length.class);

	/**
	 * One thousand part of inch.
	 */
	public static final AbstractUnit<Length> THOU = BUILDER.unit("thou", INCH, new Rational(1, 1000), Length.class);

	/**
	 * Foot.
	 */
	public static final AbstractUnit<Length> FOOT = BUILDER.unit("foot", INCH, 12, Length.class);

	/**
	 * Yard.
	 */
	public static final AbstractUnit<Length> YARD = BUILDER.unit("yard", FOOT, 3, Length.class);

	/**
	 * Rod.
	 */
	public static final AbstractUnit<Length> ROD = BUILDER.unit("rod", YARD, new Rational(11, 2), Length.class);

	/**
	 * Chain.
	 */
	public static final AbstractUnit<Length> CHAIN = BUILDER.unit("chain", FOOT, 66, Length.class);

	/**
	 * Furlong.
	 */
	public static final AbstractUnit<Length> FURLONG = BUILDER.unit("furlong", FOOT, 660, Length.class);

	/**
	 * Mile.
	 */
	public static final AbstractUnit<Length> MILE = BUILDER.unit("mile", YARD, 1760, Length.class);

	/**
	 * League.
	 */
	public static final AbstractUnit<Length> LEAGUE = BUILDER.unit("league", MILE, 3, Length.class);

	/**
	 * Nautical mile.
	 */
	public static final AbstractUnit<Length> NAUTICAL_MILE = BUILDER.unit("mile_nautical", FOOT, 6080, Length.class);

	/**
	 * Cable.
	 */
	public static final AbstractUnit<Length> CABLE = BUILDER.unit("cable", NAUTICAL_MILE, new Rational(1, 10),
			Length.class);

	/**
	 * Fathom.
	 */
	public static final AbstractUnit<Length> FATHOM = BUILDER.unit("fathom", NAUTICAL_MILE, new Rational(1, 1000),
			Length.class);

	///////////////////////// Area British Imperial Units /////////////////////////

	/**
	 * Square inch.
	 */
	public static final AbstractUnit<Area> SQUARE_INCH = BUILDER.unit(INCH.pow(2), Area.class);

	/**
	 * Square foot.
	 */
	public static final AbstractUnit<Area> SQUARE_FOOT = BUILDER.unit(FOOT.pow(2), Area.class);

	/**
	 * Square yard.
	 */
	public static final AbstractUnit<Area> SQUARE_YARD = BUILDER.unit(YARD.pow(2), Area.class);

	/**
	 * Square rod.
	 */
	public static final AbstractUnit<Area> SQUARE_ROD = BUILDER.unit(ROD.pow(2), Area.class);

	/**
	 * Rood.
	 */
	public static final AbstractUnit<Area> ROOD = BUILDER.unit(FURLONG.multiply(ROD).alternate("rood"), Area.class);

	/**
	 * Acre.
	 */
	public static final AbstractUnit<Area> ACRE = BUILDER.unit("acre", ROOD, 4, Area.class);

	/**
	 * Square mile.
	 */
	public static final AbstractUnit<Area> SQUARE_MILE = BUILDER.unit("square_mile", ACRE, 640, Area.class);

	///////////////////////// Volume British Imperial Units /////////////////////////

	/**
	 * Cubic inch.
	 */
	public static final AbstractUnit<Volume> CUBIC_INCH = BUILDER.unit(INCH.pow(3), Volume.class);

	/**
	 * Cubic foot.
	 */
	public static final AbstractUnit<Volume> CUBIC_FOOT = BUILDER.unit(FOOT.pow(3), Volume.class);

	/**
	 * Cubic yard.
	 */
	public static final AbstractUnit<Volume> CUBIC_YARD = BUILDER.unit(YARD.pow(3), Volume.class);

	///////////////////////// Dry & Wet Volume British Imperial Units /////////////////////////

	/**
	 * Gallon.
	 */
	public static final AbstractUnit<Volume> GALLON = BUILDER.unit("gallon", CUBIC_INCH,
			new BigRational(3_229_440, 11_641), Volume.class);

	/**
	 * Peck.
	 */
	public static final AbstractUnit<Volume> PECK = BUILDER.unit("peck", GALLON, 2, Volume.class);

	/**
	 * Bushel.
	 */
	public static final AbstractUnit<Volume> BUSHEL = BUILDER.unit("bushel", GALLON, 8, Volume.class);

	/**
	 * Strike.
	 */
	public static final AbstractUnit<Volume> STRIKE = BUILDER.unit("strike", BUSHEL, 2, Volume.class);

	/**
	 * Quarter or pail.
	 */
	public static final AbstractUnit<Volume> PAIL = BUILDER.unit("pail", BUSHEL, 8, Volume.class);

	/**
	 * Chaldron.
	 */
	public static final AbstractUnit<Volume> CHALDRON = BUILDER.unit("chaldron", BUSHEL, 32, Volume.class);

	/**
	 * Quart.
	 */
	public static final AbstractUnit<Volume> QUART = BUILDER.unit("quart", GALLON, Rational.ONE_FOURTH, Volume.class);

	/**
	 * Pint.
	 */
	public static final AbstractUnit<Volume> PINT = BUILDER.unit("pint", GALLON, Rational.ONE_EIGHTH, Volume.class);

	/**
	 * Gill.
	 */
	public static final AbstractUnit<Volume> GILL = BUILDER.unit("gill", PINT, Rational.ONE_FOURTH, Volume.class);

	/**
	 * Fluid ounce.
	 */
	public static final AbstractUnit<Volume> FLUID_OUNCE = BUILDER.unit("fluid_ounce", GILL, Rational.ONE_FIFTH,
			Volume.class);

	/**
	 * Fluid dram.
	 */
	public static final AbstractUnit<Volume> FLUID_DRAM = BUILDER.unit("fluid_dram", FLUID_OUNCE, Rational.ONE_EIGHTH,
			Volume.class);

	/**
	 * Minim.
	 */
	public static final AbstractUnit<Volume> MINIM = BUILDER.unit("minim", FLUID_DRAM, new Rational(1, 60),
			Volume.class);

	///////////////////////// Mass British Imperial Units /////////////////////////

	/**
	 * Grain.
	 */
	public static final AbstractUnit<Mass> GRAIN = BUILDER.unit(TroyUnits.GRAIN, Mass.class);

	/**
	 * Pound.
	 */
	public static final AbstractUnit<Mass> POUND = BUILDER.unit("pound", GRAIN, 7000, Mass.class);

	/**
	 * Drachm.
	 */
	public static final Unit<Mass> DRACHM = BUILDER.unit("drachm", POUND, new BigRational(1, 256), Mass.class);

	/**
	 * Ounce.
	 */
	public static final Unit<Mass> OUNCE = BUILDER.unit("ounce", POUND, new BigRational(1, 16), Mass.class);

	/**
	 * Stone.
	 */
	public static final Unit<Mass> STONE = BUILDER.unit("stone", POUND, 14, Mass.class);

	/**
	 * Quarter.
	 */
	public static final Unit<Mass> QUARTER = BUILDER.unit("quarter", POUND, 28, Mass.class);

	/**
	 * Hundredweight.
	 */
	public static final Unit<Mass> CWT = BUILDER.unit("hundredweight", POUND, 112, Mass.class);

	/**
	 * Long ton.
	 */
	public static final Unit<Mass> TON = BUILDER.unit("ton", POUND, 2240, Mass.class);

	///////////////////////// Speed British Imperial Units /////////////////////////

	/**
	 * Foot per second.
	 */
	public static final Unit<Speed> FOOT_PER_SECOND = BUILDER.unit(FOOT.divide(SECOND), Speed.class);

	///////////////////////// System of British Imperial Units /////////////////////////

	/**
	 * The instance of {@link SystemOfUnits}.
	 */
	public static final SystemOfUnits SYSTEM = BUILDER.build();

	private ImperialUnits() {
	}

	static final class BuilderHolder {

		static final SystemOfUnitsImpl.Builder BUILDER = SystemOfUnitsImpl.builder("Imperial");

		private BuilderHolder() {
		}
	}
}
